package rebue.pnt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rebue.pnt.jo.PntLogJo;

public interface PntLogDao extends JpaRepository<PntLogJo, Long> {

}
