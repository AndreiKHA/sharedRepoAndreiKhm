package Tests;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CountriesTests extends TestBase {

    @Test
    public void sortingTest() {
        //List to compare
        List<String> countriesSortedList = new ArrayList<String>();
        List<String> countriesActualList = new ArrayList<String>();

        List<String> zonesSortedList = new ArrayList<>();
        List<String> zonesActualList = new ArrayList<>();

        // Find Country table
        app.driver.findElement(By.xpath("//span[contains(text(), 'Countries')]/../..")).click();
        app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement table = app.driver.findElement(By.xpath("//form[@name = 'countries_form']/table/tbody"));
        List<WebElement> rows = table.findElements(By.xpath("//tr"));

        // Iterate the rows from Country table and fill the "actualList"
        for (int i = 1; i < rows.size() - 1; i++) {
            String countryName = app.driver.findElement(By.xpath("//form[@name = 'countries_form']/table/tbody/tr[" + i + "]/td[5]")).getAttribute("outerText");
            countriesActualList.add(countryName);

            // Get zones amount
            int countryZones = Integer.parseInt(app.driver.findElement(By.xpath("//form[@name = 'countries_form']/table/tbody/tr[" + i + "]/td[6]")).getAttribute("textContent"));

            // If number of zones in the Country > 0, Iterate country zones table and fill the "zonesActualList"
            if (countryZones > 0) {
                System.out.println("Country with number of zones equals " + countryZones + ": " +  countryName);
                // Find Country Zones Table
                // Open Country Zones page
                app.driver.findElement(By.xpath("//form[@name = 'countries_form']/table/tbody/tr[" + i + "]/td[5]/a")).click();
                //app.driver.switchTo().window();
                app.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                // Get Country Zones table
                WebElement zonesTable = app.driver.findElement(By.xpath("//form[@name = 'country_form']/table/tbody"));
                List<WebElement> zoneTableRows = zonesTable.findElements(By.xpath("//tr"));
                // Iterate Country Zones Table and fill "zonesActualList"
                for (int j = 1; j < zoneTableRows.size() - 1; j++) {
                    String zoneName = app.driver.findElement(By.xpath("//form[@name = 'country_form']/table/tbody/tr[" + j + "]/td[3]/input")).getAttribute("value");
                    zonesActualList.add(zoneName);
                    System.out.print(zoneName + "; ");
                }
                System.out.println();
                // Get back to the Countries page
                app.driver.findElement(By.xpath("//span[contains(text(), 'Countries')]/../..")).click();
                app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }
        }

        //Print out country sorted lists
        System.out.println("List of all Countries in table: ");
        for (int i = 0; i < countriesSortedList.size(); i++) {
            System.out.print(countriesSortedList.get(i) + " ");
        }

        // Fill "countriesSortedList", sort and compare with "countriesActualList"
        for (int i = 0; i < countriesActualList.size(); i++) {
            countriesSortedList.add(countriesActualList.get(i));
        }
        Collections.sort(countriesSortedList);
        Assert.assertTrue(countriesSortedList.equals(countriesActualList));

        // Fill "zonesSortedList", sort and compare with "zonesActualList"
        for (int i = 0; i < zonesActualList.size(); i++) {
            zonesSortedList.add(zonesActualList.get(i));
        }
        Collections.sort(zonesSortedList);
        Assert.assertTrue(zonesSortedList.equals(zonesActualList));





    }
}
