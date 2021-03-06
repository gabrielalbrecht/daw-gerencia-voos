package br.edu.ifsul.testes;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.model.VooAgendado;

class EditarVooAgendado {
	EntityManager em;

	@BeforeEach
	void setUp() throws Exception {
		em = EntityManagerUtil.getEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test() {
		try {
			VooAgendado va = em.find(VooAgendado.class, 1);
			va.setAeronave("AeronaveEditada");

			em.getTransaction().begin();
			em.merge(va);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro: " + e);
		}
	}

}
