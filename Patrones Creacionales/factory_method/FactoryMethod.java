import java.util.Map;

interface Report {
    String generate(Map<String, Object> data);
}

class JSONReport implements Report {
    @Override
    public String generate(Map<String, Object> data) {
        return "Generado reporte JSON con los datos: " + data.toString();
    }
}

class CSVReport implements Report {
    @Override
    public String generate(Map<String, Object> data) {
        StringBuilder csvData = new StringBuilder("Clave,Valor\n");
        data.forEach((key, value) -> csvData.append(key).append(",").append(value).append("\n"));
        return "Generado reporte CSV:\n" + csvData;
    }
}

class ReportFactory {
    public static Report createReport(String format) {
        if ("json".equalsIgnoreCase(format)) {
            return new JSONReport();
        } else if ("csv".equalsIgnoreCase(format)) {
            return new CSVReport();
        } else {
            throw new IllegalArgumentException("Formato de reporte no válido: " + format);
        }
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        Map<String, Object> reportData = Map.of(
            "Producto", "Laptop",
            "Precio", 1200.99,
            "Stock", 50
        );

        Report jsonReport = ReportFactory.createReport("json");
        System.out.println(jsonReport.generate(reportData));

        Report csvReport = ReportFactory.createReport("csv");
        System.out.println(csvReport.generate(reportData));
    }
}
