package br.edu.ifsul.testes;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.model.Classe;

class EditarClasse {
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
			Classe c = em.find(Classe.class, 1);
			c.setNome("ClasseEditada");

			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro: " + e);
		}
	}

}
