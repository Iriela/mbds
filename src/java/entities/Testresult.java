/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iriel
 */
@Entity
@Table(name = "TESTRESULT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testresult.findAll", query = "SELECT t FROM Testresult t")
    , @NamedQuery(name = "Testresult.findByIdtestresult", query = "SELECT t FROM Testresult t WHERE t.idtestresult = :idtestresult")
    , @NamedQuery(name = "Testresult.findByScore", query = "SELECT t FROM Testresult t WHERE t.score = :score")
    , @NamedQuery(name = "Testresult.findByIduser", query = "SELECT t FROM Testresult t WHERE t.iduser = :iduser")
    , @NamedQuery(name = "Testresult.findByIdlist", query = "SELECT t FROM Testresult t JOIN Test ts ON ts.idtest = t.idtest where ts.idlist = :idlist")
    , @NamedQuery(name = "Testresult.findByCreationdate", query = "SELECT t FROM Testresult t WHERE t.creationdate = :creationdate")
    , @NamedQuery(name = "Testresult.findByModificationdate", query = "SELECT t FROM Testresult t WHERE t.modificationdate = :modificationdate")})
public class Testresult implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTESTRESULT")
    private Long idtestresult;
    @Column(name = "SCORE")
    private Short score;
    @Basic(optional = false)
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Basic(optional = false)
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;
    @JoinColumn(name = "IDTEST", referencedColumnName = "IDTEST")
    @ManyToOne(optional = false)
    private Test idtest;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Users iduser;

    public Testresult() {
    }

    public Testresult(Long idtestresult) {
        this.idtestresult = idtestresult;
    }

    public Testresult(Long idtestresult, Date creationdate, Date modificationdate) {
        this.idtestresult = idtestresult;
        this.creationdate = creationdate;
        this.modificationdate = modificationdate;
    }

    public Long getIdtestresult() {
        return idtestresult;
    }

    public void setIdtestresult(Long idtestresult) {
        this.idtestresult = idtestresult;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    public Test getIdtest() {
        return idtest;
    }

    public void setIdtest(Test idtest) {
        this.idtest = idtest;
    }

    public Users getIduser() {
        return iduser;
    }

    public void setIduser(Users iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtestresult != null ? idtestresult.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testresult)) {
            return false;
        }
        Testresult other = (Testresult) object;
        if ((this.idtestresult == null && other.idtestresult != null) || (this.idtestresult != null && !this.idtestresult.equals(other.idtestresult))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Testresult[ idtestresult=" + idtestresult + " ]";
    }
    
}
