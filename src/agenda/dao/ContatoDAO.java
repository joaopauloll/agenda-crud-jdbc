package agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.mysql.jdbc.PreparedStatement;

import agenda.factory.ConnectionFactory;
import agenda.model.Contato;

public class ContatoDAO {

    private Connection connection = null;
    private PreparedStatement pstm = null;
    private ResultSet rset = null; // para o READ

    public void save(Contato contato) {
        String sql = "INSERT INTO contatos (nome, idade, dataCadastro) VALUES (?, ?, ?)";

        try {
            // Criar uma conexão com o banco de dados
            connection = ConnectionFactory.createConnectionToMySQL();
            // Criar uma PreparedStatement, para executar uma query
            pstm = connection.prepareStatement(sql);

            // Adicionar os valores esperados pela query
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            pstm.executeUpdate(); // ou .execute()

            System.out.println("Contato salvo com sucesso!\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void update(Contato contato) {
        String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ? WHERE id = ?";

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            pstm.setInt(4, contato.getId());

            pstm.executeUpdate();

            System.out.println("Contato atualizado com sucesso!\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM contatos WHERE id = ?";

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = connection.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.executeUpdate();

            System.out.println("Contato deletado com sucesso!\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public List<Contato> getContatos() {
        String sql = "SELECT * FROM contatos";

        List<Contato> contatos = new ArrayList<>();

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = connection.prepareStatement(sql);
            rset = pstm.executeQuery(); // ou .execute()

            while (rset.next()) {
                Contato contato = new Contato();

                contato.setId(rset.getInt("id"));
                contato.setNome(rset.getString("nome"));
                contato.setIdade(rset.getInt("idade"));
                contato.setDataCadastro(rset.getDate("dataCadastro"));

                contatos.add(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return contatos;
    }

    public Contato getContatoById(int id) {
        String sql = "SELECT * FROM contatos WHERE id = ?";

        Contato contato = new Contato();

        try {
            connection = ConnectionFactory.createConnectionToMySQL();
            pstm = connection.prepareStatement(sql);

            pstm.setInt(1, id);

            rset = pstm.executeQuery(); // ou .execute()
            rset.next();

            contato.setId(rset.getInt("id"));
            contato.setNome(rset.getString("nome"));
            contato.setIdade(rset.getInt("idade"));
            contato.setDataCadastro(rset.getDate("dataCadastro"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return contato;
    }

    private void close() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rset != null) {
                rset.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
