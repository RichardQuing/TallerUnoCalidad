from abc import ABC, abstractmethod

class Report(ABC):

    @abstractmethod
    def generate(self, data):
        pass 

class PDFReport(Report):
    def generate(self, data):
        return f'Generado reporte PDF con los datos: {data}'
    
class ExcelReport(Report):
    def generate(self, data):
        return f'Generado reporte Excel con los datos: {data}'

class ReportFactory:
    @staticmethod
    def create_report(format):
        if format == 'pdf':
            return PDFReport()
        elif format == 'excel':
            return ExcelReport()
        else:
            raise ValueError(f'Formato de reporte no valido: {format}')
        
pdf_report = ReportFactory.create_report('pdf')
print(pdf_report.generate({'nombre': 'John', 'edad': 30}))

excel_report = ReportFactory.create_report('excel')
print(excel_report.generate({'nombre': 'John', 'edad': 30}))