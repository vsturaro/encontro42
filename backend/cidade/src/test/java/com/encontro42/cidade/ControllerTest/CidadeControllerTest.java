package com.encontro42.cidade.ControllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.encontro42.cidade.controller.CidadeController;
import com.encontro42.cidade.entity.Cidade;
import com.encontro42.cidade.repository.CidadeRepository;
@SpringBootTest
class CidadeControllerTest {

	@Autowired
	private CidadeRepository repositorio;
	
	@Autowired
	private CidadeController controller;
	
	@Test
	void testListarCidade() {
		try {
			long expected;
			expected = repositorio.count();
			
			List<Cidade> lista = controller.listarCidade();
			long result = (long)lista.size();
			
			System.out.print("Teste de listar cidade: Esperado: " + expected + " obtido: " + result + "\n");
			if(expected == result) {
				System.out.println("Teste Ok");
			} else {
				System.out.println("Fail");
			}
			
			assertThat(expected).isEqualTo(result);
		}
		catch (Exception msg) {
			fail("Erro ao testar o banco de dados: " +msg.getMessage());
		}
	}
	
	@Test
	void testIncluirCidade() {
		try {
			long expected = repositorio.count()+1;
			
			Cidade nova = new Cidade();
			nova.setCodigo(0);
			nova.setNome("Campo Grande");
			nova.setEstado("Mato Grosso do Sul");
			nova.setCep("79010-100");
		
			
			controller.incluir(nova);
			
			long result = repositorio.count();
			assertThat(expected).isEqualTo(result);
			
			if(expected == result) {
				System.out.println("Teste incluir Cidade validado!");
			} else {
				System.out.println("Teste falhou: esperado " + expected + " resultado " + result);
			}
				
		}
		catch (Exception msg) {
			fail("Erro ao testar incluir cidade: " +msg.getMessage());
		}
	}

}
