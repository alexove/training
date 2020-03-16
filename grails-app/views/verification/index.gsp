<!DOCTYPE html>
<html lang="es">
    <head>
        <meta name="layout" content="main">
        <title>Verificación de Certificados</title>
        <style media="screen">
            #content {
                padding-top: 30px;
            }
            h1{
                font-size: 25px;
            }

        </style>
    </head>
    <body>
        <div id="content" role="main">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="txt-left">Herramienta de verificación de certificados</h1>
                    </div>
                    <div class="col-md-6">
                        <p class="text-lg-left">Las personas que obtienen una de nuestras certificaciones
                           representan el mejor talento disponible y tienen las
                           habilidades necesarias para tener un impacto inmediato.
                           Esta herramienta de verificación le permite confirmar
                           la validez de la certificación de un candidato de trabajo.</p>
                        </div>
                        <div class="col-md-6">
                            <g:if test="${existe}">
                            <div class="alert alert-success" role="alert">
                                <h4 class="alert-heading">Certificado encontrado</h4>
                                <p>El certificado es <b>VALIDO</b> y esta otorgado a <b>${student?.name} ${student?.lastName}</b> con el siguiente detalle:</p>
                                <ul class="list-group">
                                    <li class="list-group-item">DNI:<b>${student.dni}</b></li>
                                    <li class="list-group-item">Nombre completo:<b>${student?.name} ${student?.lastName}</b></li>
                                    <li class="list-group-item">Curso:<b>${course?.title}</b></li>
                                    <li class="list-group-item">Duración:<b>${course?.academicHours} horas academicas</b></li>
                                    <li class="list-group-item">Desempeño: <b>Sobresaliente</b></li>
                                </ul>
                                <hr>
                                <p class="mb-0"><a href="/verification/index" class="alert-link">Hacer una nueva consulta.</a></p>
                            </div>
                            </g:if>
                            <g:if test="${existe==false}">
                            <div class="alert alert-warning" role="alert">
                                <h2>Datos no encontrados</h2>
                                <p>Los datos ingresados no son validos, por favor verifiquelos
                                   e <a href="/verification/index" class="alert-link">intentelo de nuevo</a>
                                </p>
                            </div>
                            </g:if>
                            <g:if test="${existe==null}">
                                <g:form name="name" action="index">
                                <div class="form-group">
                                    <label for="">Apellidos *</label>
                                    <input type="text" name="lastName" value="" class="form-control">
                                    <small class="form-text text-muted">Ingrese los apellidos tal como aparecen en el certificado</small>
                                </div>
                                <div class="form-group">
                                    <label for="">Serie del Certificado *</label>
                                    <input type="text" name="serialNumber" value="" class="form-control">
                                    <small class="form-text text-muted">Ingrese el numero de serie tal como aparecen en el certificado</small>
                                </div>
                                <div class="form-group form-check">
                                    <input type="checkbox" name="" value="" class="form-check-input" onchange="document.getElementById('btn_check').disabled = !this.checked;">
                                    <label for="" class="form-check-label"  >Estoy de acuerdo con los
                                        <a href="#">Terminos del servicio </a> de la pagina de
                                        verificación de certificados de Andean Technologies
                                        S.A.C.</label>
                                    </div>
                                    <button id="btn_check" type="submit" name="button" class="btn btn-primary btn-block" disabled>Verificar</button>
                                </g:form>
                            </g:if>

                        </div>

                    </div>
                </div>
        </div>
    </body>
</html>
