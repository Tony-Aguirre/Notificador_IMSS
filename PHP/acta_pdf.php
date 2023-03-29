<?php
    require('fpdf/fpdf.php');
    $nombre=$_GET['nombre'];
    $registro_patronaldo=$GET['registro_patronaldo'];
    $rfc=GET['rfc'];
    $domicilio=GET['domicilio'];
    $credito=GET['credito'];
    $multa=GET['multa'];
    $periodo=GET['periodo'];
    $fecha=GET['fecha'];
    $notificador=GET['notificador'];
    $atiende=GET['atiende'];
    $relacion=GET['relacion'];
    $identifica=GET['identifica']:
    $identificacion=GET['identificacion'];
    $numero=GET['numero'];
    $fechaID=GET['fechaID'];
    $vigencia=GET['vigencia'];
    $rasgos=GET['rasgos'];
    $dia = date("d");
    $mes = date("m");
    $anio = date("Y");
    $hora = date("h");
    $minutos = date("i");
    $pdf = new FPDF();
    $pdf->AddPage();
    $pdf->SetTitle('Generar archivos PDF con PHP');
    $pdf->SetAuthor('Instituto Mexicano del Seguro Social');
    $pdf->SetCreator('Notificador IMSS');
    $pdf->Image('titulo.png',null,null,190);
    $pdf->SetFont('Times','B',10);
    $pdf->MultiCell(0,7,utf8_decode('Datos del Patron, Denominación o Razón Social'),0,1);
    $pdf->SetFont('Times', '',10);
    $pdf->MultiCell(0,7,utf8_decode('Nombre: ' . $nombre . '     Registro Patronaldo: ' . $registro_patronaldo . '     R.F.C.: ' . $rfc),0,1);
    $pdf->MultiCell(0,7,utf8_decode('Domicilio: ' . $domicilio),0,1);
    $pdf->SetFont('Times','B',10);
    $pdf->MultiCell(0,7,utf8_decode('Detalle de documentos'),0,1);
    $pdf->SetFont('Times', '',10);
    $pdf->MultiCell(0,7,utf8_decode('Cédula de Liquidación por La Omisión Total en la Determinación y Pago de Cuotas'),0,1);
    $pdf->MultiCell(0,7,utf8_decode('Crédito:   ' . $credito . '     Multa:   ' . $multa . '     Periodo:   ' . $periodo . '     Fecha:   ' . $fecha),0,1);
    $pdf->SetFont('Times','B',10);
    $pdf->MultiCell(0,7,utf8_decode('ACTA DE NOTIFICACIÓN'),0,'C',false);
    $pdf->SetFont('Times','',10);
    $pdf->MultiCell(0,7,utf8_decode('En Empalme, Sonora, siendo las ' . $hora . ' horas con ' . $minutos . ' minutos del día ' . $dia . ' de ' . $mes . ' de ' . $anio . ', el suscrito Notificador C. '
                                    . $notificador . ', autorizado para realizar la presente diligencia, me constituyo legalmente en el domicilio del patrón y/o su representante legal o de la persona a la que van dirigidos los documentos al '
                                    . $nombre . ', sito en '
                                    . $domicilio . ', con fundamento en los artículos 14 párrafo segundo, 16 párrafo primero y 31 fracción IV de la Constitución Política de los Estados Unidos Mexicanos; artículo 3, fracción I, primer párrafo, y 45 de la Ley Orgánica de la Administración Pública Federal; 5 y 14, fracción III de la Ley Federal de las Entidades Paraestatales; 5, 40 y 251, primer párrafo, fracciones IV, XXVI y XXXVII de la Ley del Seguro Social vigente; 2, primer párrafo, fracciones IV, inciso a) y VI, inciso b), 142, primer párrafo, fracción II, 149, 150, fracción IX, 152 y 155 fracción XXVI, párrafos primero y segundo, inciso d), párrafos primero y segundo del Reglamento Interior del Instituto Mexicano del Seguro Social en vigor; así como 10, 13, 134 párrafo primero, fracción I, 135, 136 y 137, del Código Fiscal de la Federación vigente; y una vez que me cercioré que este es el domicilio del patrón, persona buscada o quien legalmente le representa, domicilio que coincide con el indicado en el presente documento además, por así señalarse en indicadores del sector, así como por el dicho de la persona que me atiende en el domicilio, quien dijo llamarse C. '
                                    . $atiende . ', quien manifestó ser mayor de edad y tener capacidad legal para atender el acto, quien manifestó tener una relación '
                                    . $relacion . ' y quien ' . $identifica . ' se identifica con ' . $identificacion . ' número ' . $numero . ', de fecha ' . $fechaID . ', expedida por ' . $identificacion . ', vigente ' . $vigencia . ' y que contiene fotografía que corresponde a los rasgos fisonómicos de la persona que atiende los cuales son: '
                                    . $rasgos . ', una vez que se tuvo a la vista se devuelve al portador, por lo que con fundamento en las disposiciones legales invocadas y los motivos señalados en el mismo, procedo a requerir la presencia del patrón o de su representante legal o persona a la que van dirigidos los documentos, a la persona que me atiende en el domicilio y que ha quedado descrita.'),0,'J',false);
    $pdf->SetFont('Times','B',10);
    $pdf->MultiCell(0,7,utf8_decode('Constancia de entrega de los documentos'),0,1);
    $pdf->SetFont('Times','',10);
    $pdf->MultiCell(0,7,utf8_decode('Acto seguido, ante la presencia del (de la) C. ' . $atiende
                                   . ', persona con quien se entiende la diligencia y quien manifestó ser mayor de edad y tener capacidad legal para atender el acto, hago entrega y notifico los documentos descritos en el Detalle de documentos, emitidos por la Subdelegación Guaymas, los cuales se encuentran en original y signados con firma autógrafa del funcionario competente, así como un tanto de la presente acta, con firmas autógrafas y que consta de 1 fojas útiles, dando así cumplimiento a lo dispuesto en los artículos 134 primer párrafo, fracción I, 135 primer párrafo y 137, párrafos primero y segundo del Código Fiscal de la Federación; levantando la presente de conformidad con lo establecido en el artículo 135, primer párrafo del citado Código'
                                   . ', y no habiendo más que hacer constar en la presente diligencia, se da por concluida siendo las '
                                   . $hora . ' horas con ' . $minutos+15 . ' minutos del día en que se actúa, firmando al calce los que intervinieron en la misma y así quisieron hacerlo.'),0,'J',false);
    $pdf->Output('', 'acta-' . $registro_patronaldo . '.pdf');
?>
