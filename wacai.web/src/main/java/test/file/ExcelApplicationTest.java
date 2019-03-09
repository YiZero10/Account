package test.file;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Date;

public class ExcelApplicationTest {
    public static void main(String[] args) {
        write();
        read();
    }

    public static void read(){
        InputStream inputStream = null;
        try {
           inputStream = new FileInputStream("workbook.xlsx");//这是一个流  之后要建一个workbook
           Workbook wb = WorkbookFactory.create(inputStream);
            /**
             * https://poi.apache.org/components/spreadsheet/quick-guide.html#CellContents
             * 复制粘贴 理解 读取这个表
             */
            DataFormatter formatter = new DataFormatter();
            Sheet sheet1 = wb.getSheetAt(0);
            for (Row row : sheet1) {
                for (Cell cell : row) {
                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    System.out.print(cellRef.formatAsString());
                    System.out.print(" - ");

                    // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                    String text = formatter.formatCellValue(cell);
                    System.out.println(text);

                    // Alternatively, get the value and format it yourself
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.println(cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.println(cell.getDateCellValue());
                            } else {
                                System.out.println(cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            System.out.println(cell.getCellFormula());
                            break;
                        case BLANK:
                            System.out.println();
                            break;
                        default:
                            System.out.println();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void write(){

        OutputStream fileOut = null;

        try {
            fileOut = new FileOutputStream("workbook.xlsx");
            /*创建一个workbook */
            Workbook wb = new XSSFWorkbook();
            /*创建sheet*/
            Sheet sheet1 = wb.createSheet("sheet1");
            Sheet sheet2 = wb.createSheet("sheet2");
            /*创建row 和 cell 以及设置值*/
            Row row = sheet1.createRow(0);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(1.0);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue("HELLO");

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(new Date());     //显示的时间不是格式化的

            CellStyle cellStyle = wb.createCellStyle();
            CreationHelper creationHelper = wb.getCreationHelper();
            cellStyle.setDataFormat(
                    creationHelper.createDataFormat().getFormat("MM/dd/yyyy HH:mm"));
            cell2.setCellStyle(cellStyle);
            wb.write(fileOut);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOut != null){
                try {
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
