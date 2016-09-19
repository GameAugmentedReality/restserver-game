package br.eti.francisco.restserver.persistence;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.eti.francisco.restserver.entity.ChaveAcesso;

@Repository("chaveAcessoDao")
public class ChaveAcessoDaoJpa extends PersistenciaJpa<ChaveAcesso> implements ChaveAcessoDao{

   private static final long serialVersionUID = 1L;
   
   
//   private static Map<String, ChaveAcesso> mapaChaves = new HashMap<String, ChaveAcesso>();
//   
//   static{
//      /*Exemplo/Fake para criação do mapa de chaves*/
//      ChaveAcesso ch1 = new ChaveAcesso();
//      ch1.setConsumerKey("00123-XBCDFDAS");
//      ch1.setSecretKey("YUIT-YYHJ-ASDFHJUH");
//      ch1.setRoles("admin");
//      
//      mapaChaves.put(ch1.getConsumerKey(), ch1);
//   }
//
//   @Override
//   public ChaveAcesso consultar(Object consumerKey) throws PersistenciaException {
//      return mapaChaves.get(consumerKey);
//   }
   
}
