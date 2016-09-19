package br.eti.francisco.restserver.util;

public class SecurityRole {

   private final boolean denyAll;

   private final String[] rolesAllowed;

   protected SecurityRole() {
      this.denyAll = true;
      this.rolesAllowed = null;
   }

   protected SecurityRole(String[] rolesAllowed) {
      this.denyAll = false;
      this.rolesAllowed = (rolesAllowed != null) ? rolesAllowed : new String[] {};
   }

   public boolean isDenyAll() {
      return denyAll;
   }

   public String[] getRolesAllowed() {
      return rolesAllowed;
   }
   
}
