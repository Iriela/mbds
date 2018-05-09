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
@Table(name = "LIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "List.findAll", query = "SELECT l FROM List l")
    , @NamedQuery(name = "List.findByIdlist", query = "SELECT l FROM List l WHERE l.idlist = :idlist")
    , @NamedQuery(name = "List.findByTitle", query = "SELECT l FROM List l WHERE l.title = :title")
    , @NamedQuery(name = "List.findByDescription", query = "SELECT l FROM List l WHERE l.description = :description")
    , @NamedQuery(name = "List.findByIduser", query = "SELECT l FROM List l WHERE l.iduser = :iduser")
    , @NamedQuery(name = "List.findByCreationdate", query = "SELECT l FROM List l WHERE l.creationdate = :creationdate")
    , @NamedQuery(name = "List.findByModificationdate", query = "SELECT l FROM List l WHERE l.modificationdate = :modificationdate")
    , @NamedQuery(name = "List.findByKeyword", query = "SELECT l FROM List l WHERE l.keyword = :keyword")
    , @NamedQuery(name = "List.deleteAll", query = "DELETE FROM List")
})
public class List implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlist")
    private Collection<Test> testCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDLIST")
    private Long idlist;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Basic(optional = false)
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;
    @Column(name = "KEYWORD")
    private String keyword;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Users iduser;

    public List() {
    }

    public List(Long idlist) {
        this.idlist = idlist;
    }

    public List(Long idlist, String title, String description, Users iduser,Date creationdate, Date modificationdate) {
        this.idlist = idlist;
        this.title = title;
        this.description = description;
        this.iduser = iduser;
        this.creationdate = creationdate;
        this.modificationdate = modificationdate;
    }

    public Long getIdlist() {
        return idlist;
    }

    public void setIdlist(Long idlist) {
        this.idlist = idlist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
        hash += (idlist != null ? idlist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof List)) {
            return false;
        }
        List other = (List) object;
        if ((this.idlist == null && other.idlist != null) || (this.idlist != null && !this.idlist.equals(other.idlist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.List[ idlist=" + idlist + " ]";
    }

    @XmlTransient
    public Collection<Test> getTestCollection() {
        return testCollection;
    }

    public void setTestCollection(Collection<Test> testCollection) {
        this.testCollection = testCollection;
    }
    
}
