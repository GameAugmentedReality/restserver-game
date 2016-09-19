package br.eti.francisco.restserver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ChaveAcesso {

   @Id
   private String consumerKey;
   
   private String secretKey;

   private String roles;
   
   @Transient
   private long timestamp;
   
   public String [] getRolesArray(){
      if(roles != null){
         String [] rolesProv = roles.split(",");
         for (int i = 0; i < rolesProv.length; i++) {
            rolesProv[i] = rolesProv[i].trim();
         }
         return rolesProv;
      }else{
         return new String[0];
      }
   }
   
   public String getConsumerKey() {
      return consumerKey;
   }

   public void setConsumerKey(String consumerKey) {
      this.consumerKey = consumerKey;
   }

   public String getSecretKey() {
      return secretKey;
   }

   public void setSecretKey(String secretKey) {
      this.secretKey = secretKey;
   }

   public String getRoles() {
      return roles;
   }

   public void setRoles(String roles) {
      this.roles = roles;
   }

   public long getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(long timestamp) {
      this.timestamp = timestamp;
   }
   
}
