package agenda.aplicacao;

import java.util.Date;

import agenda.dao.ContatoDAO;
import agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		ContatoDAO contatoDao = new ContatoDAO();

		// CREATE
		Contato contato = new Contato();
		contato.setNome("maria");
		contato.setIdade(30);
		contato.setDataCadastro(new Date());

		// contatoDao.save(contato);

		// UPDATE
		Contato contatoAtualizado = new Contato();
		contatoAtualizado.setNome("pedro3");
		contatoAtualizado.setIdade(32);
		contatoAtualizado.setDataCadastro(new Date());
		contatoAtualizado.setId(4);

		// contatoDao.update(contatoAtualizado);

		// DELETE
		// contatoDao.deleteById(11);

		// READ
		for (Contato c : contatoDao.getContatos()) {
			System.out.println(c.getNome() + "\t" + c.getIdade() + "\t" +
					c.getDataCadastro() + "\t" + c.getId());
		}

		// GET BY ID
		Contato c = contatoDao.getContatoById(2);
		System.out
				.println("\nBY ID: " + c.getNome() + "\t" + c.getIdade() + "\t" + c.getDataCadastro() + "\t"
						+ c.getId());

	}

}
