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
@Table(name = "TEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
    , @NamedQuery(name = "Test.findByIdtest", query = "SELECT t FROM Test t WHERE t.idtest = :idtest")
    , @NamedQuery(name = "Test.findByIduser", query = "SELECT t FROM Test t WHERE t.iduser = :iduser")
    , @NamedQuery(name = "Test.findByIduserAndIdTest", query = "SELECT t FROM Test t WHERE t.iduser = :iduser and t.idtest = :idtest")
    , @NamedQuery(name = "Test.findByIdlist", query = "SELECT t FROM Test t WHERE t.idlist = :idlist")
    , @NamedQuery(name = "Test.findByScore", query = "SELECT t FROM Test t WHERE t.score = :score")
    , @NamedQuery(name = "Test.findByCreationdate", query = "SELECT t FROM Test t WHERE t.creationdate = :creationdate")
    , @NamedQuery(name = "Test.findByModificationdate", query = "SELECT t FROM Test t WHERE t.modificationdate = :modificationdate")})
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTEST")
    private Long idtest;
    @Basic(optional = false)
    @Column(name = "IDUSER")
    private long iduser;
    @Basic(optional = false)
    @Column(name = "IDLIST")
    private long idlist;
    @Column(name = "SCORE")
    private Short score;
    @Basic(optional = false)
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public Test() {
    }

    public Test(Long idtest) {
        this.idtest = idtest;
    }

    public Test(Long idtest, long iduser, long idlist, Date creationdate) {
        this.idtest = idtest;
        this.iduser = iduser;
        this.idlist = idlist;
        this.creationdate = creationdate;
    }

    public Long getIdtest() {
        return idtest;
    }

    public void setIdtest(Long idtest) {
        this.idtest = idtest;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    public long getIdlist() {
        return idlist;
    }

    public void setIdlist(long idlist) {
        this.idlist = idlist;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtest != null ? idtest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.idtest == null && other.idtest != null) || (this.idtest != null && !this.idtest.equals(other.idtest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Test[ idtest=" + idtest + " ]";
    }
    
}
