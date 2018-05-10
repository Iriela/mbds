/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    , @NamedQuery(name = "Test.findByCreationdate", query = "SELECT t FROM Test t WHERE t.creationdate = :creationdate")
    , @NamedQuery(name = "Test.findByModificationdate", query = "SELECT t FROM Test t WHERE t.modificationdate = :modificationdate")
    , @NamedQuery(name = "Test.deleteAll", query = "DELETE FROM Test")
})
public class Test implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtest")
    private Collection<Testresult> testresultCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTEST")
    private Long idtest;
    
    @Basic(optional = false)
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;
    @JoinColumn(name = "IDLIST", referencedColumnName = "IDLIST")
    @ManyToOne(optional = false)
    private List idlist;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Users iduser;

    public Test() {
    }

    public Test(Long idtest) {
        this.idtest = idtest;
    }

    public Test(Long idtest, Date creationdate) {
        this.idtest = idtest;
        this.creationdate = creationdate;
    }
    
    public Test(Long idtest,Users iduser,List idlist,Date creationdate, Date modificationdate) {
        this.idtest = idtest;
        this.idlist =idlist;
        this.iduser = iduser;
        this.creationdate = creationdate;
        this.modificationdate = modificationdate;
    }

    public Long getIdtest() {
        return idtest;
    }

    public void setIdtest(Long idtest) {
        this.idtest = idtest;
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

    public List getIdlist() {
        return idlist;
    }

    public void setIdlist(List idlist) {
        this.idlist = idlist;
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

    @XmlTransient
    public Collection<Testresult> getTestresultCollection() {
        return testresultCollection;
    }

    public void setTestresultCollection(Collection<Testresult> testresultCollection) {
        this.testresultCollection = testresultCollection;
    }
    
}
