import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class ReadProductExcel
{
    public Product[] readExcel(InputStream in) {
        Product products[] = null;
        try {
            XSSFWorkbook xw = new XSSFWorkbook(in);
            XSSFSheet xs = xw.getSheetAt(0);
            products = new Product[xs.getPhysicalNumberOfRows()];
            for (int j = 0; j < xs.getPhysicalNumberOfRows(); j++) {
                XSSFRow row = xs.getRow(j);
                Product product = new Product();
                for (int k = 0; k <= row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    if (cell == null)
                        continue;
                    if (k == 0) {
                        product.setProductID(this.getValue(cell));
                    } else if (k == 1) {
                        product.setProductName(this.getValue(cell));
                    } else if (k == 2) {
                        product.setProductPrice(this.getValue(cell));
                    }
                }
                products[j] = product;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
    public Product getProductByID(InputStream in1,String id)
    {
        Product product = null;
        try {
            product = new Product();
            boolean flag = true;
            XSSFWorkbook xw = new XSSFWorkbook(in1);
            XSSFSheet xs = xw.getSheetAt(0);
            for (int j = 0; j < xs.getPhysicalNumberOfRows(); j++)
            {

                XSSFRow row = xs.getRow(j);
                XSSFCell cell = row.getCell(0);
                if(id.equals(this.getValue(cell)))
                {
                    product.setProductID(this.getValue(cell));
                    XSSFCell cell1 = row.getCell(1);
                    product.setProductName(this.getValue(cell1));
                    XSSFCell cell2 = row.getCell(2);
                    product.setProductPrice(this.getValue(cell2));
                    flag = false;
                    return product;
                }
            }
            if(flag)
            {
                System.out.println("没有ID为" + id + "的商品");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellTypeEnum();

        switch (type) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BLANK:
                value = "";
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case NUMERIC:
                DecimalFormat df = new DecimalFormat("#");
                value = df.format(cell.getNumericCellValue());
                //value = df.format(cell.getNumericCellValue());
                //value = cell.getNumericCellValue() + "";
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case ERROR:
                value = "非法字符";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }
}
