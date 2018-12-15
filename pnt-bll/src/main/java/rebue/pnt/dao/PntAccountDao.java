package rebue.pnt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rebue.pnt.jo.PntAccountJo;

public interface PntAccountDao extends JpaRepository<PntAccountJo, Long> {

}
