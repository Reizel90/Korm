package univpm.korm.Controller;


import java.util.List;
import univpm.korm.Model.TabDatiBeacon;
import univpm.korm.Model.TabPunti;

public class HomeController {

    private TabDatiBeacon tabDatiBeacon =new TabDatiBeacon();

    private TabPunti tabPunti=new TabPunti();



    public void updatesaveBeacon(String address, String datetime,String temperature,String humidity){

         tabDatiBeacon =tabDatiBeacon.getTabBeacon(address);

         if(tabDatiBeacon.address.equals("0")){
             tabDatiBeacon =new TabDatiBeacon(address,datetime,temperature,humidity);
             tabDatiBeacon.save();
         }else
         {
             tabDatiBeacon.dateTime=datetime;
             tabDatiBeacon.temperature=temperature;
             tabDatiBeacon.humidity=humidity;
             tabDatiBeacon.save();
         }
          }

    public TabPunti TrovaCoordQuota(String address){
       return tabPunti.TrovaCoordQuotaModel(address);
    }

    public List<TabPunti> TrovaCoordQuotaPericolo(String[] address){
        return tabPunti.TrovaCoordPericoloQuotaModel(address);
    }
}
