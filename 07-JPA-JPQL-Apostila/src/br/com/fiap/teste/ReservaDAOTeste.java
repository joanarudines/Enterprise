package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.entity.Reserva;

class ReservaDAOTeste {
	
	private static ReservaDAO dao;
	
	@BeforeAll
	public static void iniciar() {
		dao = new ReservaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}

	@Test
	void pesquisarPorDataTest() {
		Calendar data = new GregorianCalendar(2000, Calendar.JULY, 28);
		List<Reserva> lista = dao.buscarPorData(data);
		for (Reserva reserva : lista) {
			assertEquals(data, reserva.getDataReserva());
		}
	}
	
	@Test
	void test() {
		List<Reserva> lista = dao.listar();
		assertEquals(3, lista.size());
	}

}
