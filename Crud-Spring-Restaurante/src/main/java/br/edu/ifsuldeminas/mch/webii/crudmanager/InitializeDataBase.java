package br.edu.ifsuldeminas.mch.webii.crudmanager;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.EntregadorRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.RestauranteRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Entregador;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Restaurante;


@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner{
    
    @Autowired
    private EntregadorRepository entregadorRepository;
    
    @Autowired
    private RestauranteRepository restauranteRepository;
    
    @Override
    public void run(String... args) throws Exception {
        Entregador entregador1 = new Entregador();
        entregador1.setNome("Aline");
        entregador1.setGenero("F");
        entregador1.setTipoVeiculo("Moto");
        entregador1.setTelefone("81424942");
        
        Entregador entregador2 = new Entregador();
        entregador2.setNome("Breno");
        entregador2.setGenero("M");
        entregador2.setTipoVeiculo("Carro");
        entregador2.setTelefone("33753734");
        
        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Donna Nana");
        restaurante1.setEndereco("Av. Paulista, 2073 - Bela Vista, São Paulo - SP");
        restaurante1.setTelefone(" (11) 3170-4033");
        restaurante1.setSite("https://www.donnanana.com.br/");
        restaurante1.setEntregador(entregador1);
        
        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("Jangada");
        restaurante2.setEndereco("Av. Paulista, 1499 - Bela Vista, São Paulo - SP");
        restaurante2.setTelefone(" (11) 3170-1010");
        restaurante2.setSite("https://www.jangada.com.br/");
        restaurante2.setEntregador(entregador1);
        
        
        entregadorRepository.save(entregador1);
        entregadorRepository.save(entregador2);
        restauranteRepository.save(restaurante1);
        restauranteRepository.save(restaurante2);
        
     }
}