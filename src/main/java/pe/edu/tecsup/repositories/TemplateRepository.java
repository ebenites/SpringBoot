package pe.edu.tecsup.repositories;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TemplateRepository {

    private static Logger log = Logger.getLogger(TemplateRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> list(){
		log.info("calling list: ");
		
		String sql = "select codpersona, general.nombrecliente(codpersona) as nombres, email from general.gen_persona where esempleado='S' and email is not null order by 2";
		
		List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException{
            	User user = new User();
				user.setId(rs.getInt("codpersona"));
				user.setFullname(rs.getString("nombres"));
				user.setEmail(rs.getString("email"));
                return user;
            }
        });
		
		log.info(list);
		
		return list;
	}

}
