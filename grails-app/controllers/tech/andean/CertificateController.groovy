package tech.andean

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CertificateController {

    CertificateService certificateService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond certificateService.list(params), model:[certificateCount: certificateService.count()]
    }

    def show(Long id) {
        respond certificateService.get(id)
    }

    def create() {
        respond new Certificate(params)
    }

    def save(Certificate certificate) {
        if (certificate == null) {
            notFound()
            return
        }

        try {
            certificateService.save(certificate)
        } catch (ValidationException e) {
            respond certificate.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'certificate.label', default: 'Certificate'), certificate.id])
                redirect certificate
            }
            '*' { respond certificate, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond certificateService.get(id)
    }

    def update(Certificate certificate) {
        if (certificate == null) {
            notFound()
            return
        }

        try {
            certificateService.save(certificate)
        } catch (ValidationException e) {
            respond certificate.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'certificate.label', default: 'Certificate'), certificate.id])
                redirect certificate
            }
            '*'{ respond certificate, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        certificateService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'certificate.label', default: 'Certificate'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'certificate.label', default: 'Certificate'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
