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
import javax.persistence.Id;
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
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByIduser", query = "SELECT u FROM Users u WHERE u.iduser = :iduser")
    , @NamedQuery(name = "Users.findByIsadmin", query = "SELECT u FROM Users u WHERE u.isadmin = :isadmin")
    , @NamedQuery(name = "Users.findByLogin", query = "SELECT u FROM Users u WHERE u.login = :login")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByCreationdate", query = "SELECT u FROM Users u WHERE u.creationdate = :creationdate")
    , @NamedQuery(name = "Users.findByModificationdate", query = "SELECT u FROM Users u WHERE u.modificationdate = :modificationdate")
    , @NamedQuery(name = "Users.connect", query = "SELECT u FROM Users u WHERE u.login = :login and u.password = :password")})
public class Users implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private Collection<Testresult> testresultCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private Collection<Test> testCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private Collection<List> listCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDUSER")
    private Long iduser;
    @Basic(optional = false)
    @Column(name = "ISADMIN")
    private Boolean isadmin;
    @Basic(optional = false)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Basic(optional = false)
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public Users() {
    }

    public Users(Long iduser) {
        this.iduser = iduser;
    }

    public Users(Long iduser, Boolean isadmin, String login, String password, Date creationdate, Date modificationdate) {
        this.iduser = iduser;
        this.isadmin = isadmin;
        this.login = login;
        this.password = password;
        this.creationdate = creationdate;
        this.modificationdate = modificationdate;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Users[ iduser=" + iduser + " ]";
    }

    @XmlTransient
    public Collection<List> getListCollection() {
        return listCollection;
    }

    public void setListCollection(Collection<List> listCollection) {
        this.listCollection = listCollection;
    }

    @XmlTransient
    public Collection<Test> getTestCollection() {
        return testCollection;
    }

    public void setTestCollection(Collection<Test> testCollection) {
        this.testCollection = testCollection;
    }

    @XmlTransient
    public Collection<Testresult> getTestresultCollection() {
        return testresultCollection;
    }

    public void setTestresultCollection(Collection<Testresult> testresultCollection) {
        this.testresultCollection = testresultCollection;
    }
    
}
