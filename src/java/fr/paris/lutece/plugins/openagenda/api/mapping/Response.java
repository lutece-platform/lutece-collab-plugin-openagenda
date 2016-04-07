/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.openagenda.api.mapping;

import java.util.List;


/* Example json from https://api.openagenda.com/v1/agendas/<UID>/events
{
   "data" : [
      {
         "title" : {
            "fr" : "Les mercredis midi du Budget Participatif"
         },
         "spacetimeinfo" : "from Wednesday, January 20, to Wednesday, February 17, at Paris Rendez Vous",
         "imageThumb" : "//cibul.s3.amazonaws.com/evtbevent_les-mercredis-midi-du-budget-participatif_818_63332.jpg",
         "tags" : {
            "fr" : null
         },
         "freeText" : {
            "fr" : "Pour vous accompagner dans la construction et le dépôt de votre projet, une permanence se tient à votre disposition à l'Hôtel de Ville, à Paris Rendez-vous. Accès libre tous les mercredis du 20 janvier au 17 février, de 12h à 14h. "
         },
         "thirdParties" : [],
         "link" : "http://openagenda.com/event/les-mercredis-midi-du-budget-participatif_818",
         "locations" : [
            {
               "dates" : [
                  {
                     "timeStart" : "12:00:00",
                     "date" : "2016-01-20",
                     "timeEnd" : "14:00:00"
                  },
               ],
               "longitude" : "2.352839",
               "cityDistrict" : "Paris 4e Arrondissement",
               "address" : "29, rue de Rivoli 75004 Paris",
               "latitude" : "48.856918",
               "slug" : "paris-rendez-vous*743",
               "verified" : false,
               "placename" : "Paris Rendez Vous",
               "department" : "Paris",
               "city" : "Le Thour",
               "postalCode" : "75004",
               "uid" : "42290715",
               "region" : "Île-de-France"
            }
         ],
         "image" : "//cibul.s3.amazonaws.com/event_les-mercredis-midi-du-budget-participatif_818_63332.jpg",
         "updatedAt" : "2016-02-05 13:50:02",
         "uid" : "64692894",
         "description" : {
            "fr" : "Permanence tous les mercredis du 20 janvier au 17 février, de 12h à 14h à Paris Rendez-vous ! "
         }
      },
   ],
   "success" : true,
   "code" : "200"
}
*/

/**
 *
 * @author mha
 */
public class Response {
    
    
    private boolean success;
    private String code;
    private List<EventData> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<EventData> getData() {
        return data;
    }

    public void setData(List<EventData> data) {
        this.data = data;
    }
    
}
