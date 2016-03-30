
import edu.uniandes.ecos.IntegradorSimpson.modelo.IntegradorSimpson;
import static spark.Spark.get;
import static spark.SparkBase.port;

/**
 * @name Main
 * @author Juan
 * @version 1.1
 * @date 25/03/2015
 * @description ejecuta los calculos de Integracion.
 */
public class Main {

    //method
    /**
     * Metodo principal del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        port(Integer.valueOf(System.getenv("PORT")));

        IntegradorSimpson integradorSimpson1 = new IntegradorSimpson(10, 9, 1.1);
        IntegradorSimpson integradorSimpson2 = new IntegradorSimpson(10, 10, 1.1812);
        IntegradorSimpson integradorSimpson3 = new IntegradorSimpson(10, 30, 2.750);

        StringBuilder response = new StringBuilder();

        try {

            response.append("<style type=\"text/css\">");
            response.append(".tg  {border-collapse:collapse;border-spacing:0;}");
            response.append(".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}");
            response.append(".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}");
            response.append(".tg .tg-yfvh{font-weight:bold;font-style:italic;vertical-align:top}");
            response.append(".tg .tg-9hbo{font-weight:bold;vertical-align:top}");
            response.append(".tg .tg-yw4l{vertical-align:top}");
            response.append("</style>");
            response.append("<table class=\"tg\">");
            response.append("<tr>");
            response.append("<th class=\"tg-9hbo\" colspan=\"2\">Test</th>");
            response.append("<th class=\"tg-9hbo\">Expected <br>Value</th>");
            response.append("<th class=\"tg-9hbo\">Actual<br>Value</th>");
            response.append("</tr>");
            response.append("<tr>");
            response.append("<td class=\"tg-yfvh\">X</td>");
            response.append("<td class=\"tg-yfvh\">dof</td>");
            response.append("<td class=\"tg-yfvh\">p</td>");
            response.append("<td class=\"tg-yfvh\">p</td>");
            response.append("</tr>");
            response.append("<tr>");
            response.append("<td class=\"tg-yw4l\">0 to x = 1.1</td>");
            response.append("<td class=\"tg-yw4l\">9</td>");
            response.append("<td class=\"tg-yw4l\">0.35006</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(integradorSimpson1.redondear(integradorSimpson1.integrar(), 5));
            response.append("</td>");
            response.append("</tr>");
            response.append("<tr>");
            response.append("<td class=\"tg-yw4l\">0 to x = 1.1812</td>");
            response.append("<td class=\"tg-yw4l\">10</td>");
            response.append("<td class=\"tg-yw4l\">0.36757</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(integradorSimpson2.redondear(integradorSimpson2.integrar(), 5));
            response.append("</td>");
            response.append("</tr>");
            response.append("<tr>");
            response.append("<td class=\"tg-yw4l\">0 to x = 1.1812</td>");
            response.append("<td class=\"tg-yw4l\">30</td>");
            response.append("<td class=\"tg-yw4l\">0.49500</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(integradorSimpson3.redondear(integradorSimpson3.integrar(), 5));
            response.append("</td>");
            response.append("</tr>");
            response.append("</table>");

            get("/", (req, res) -> response.toString());
        } catch (Exception ex) {
            response.append("No se ha podido integra la funcion debido a la siguiente excepcion: ");
            response.append(ex.getMessage());
            get("/", (req, res) -> response.toString());
        }
    }
}
