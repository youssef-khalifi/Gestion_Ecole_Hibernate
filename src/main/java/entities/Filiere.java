package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Filiere {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "CODE", nullable = false, length = 255)
    private String code;
    @Basic
    @Column(name = "LIBELLE", nullable = false, length = 255)
    private String libelle;
    @OneToMany(mappedBy = "filiere" , fetch = FetchType.LAZY)
    private Collection<Etudiant> etudiantsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Collection<Etudiant> getEtudiantsById() {
        return etudiantsById;
    }

    public void setEtudiantsById(Collection<Etudiant> etudiantsById) {
        this.etudiantsById = etudiantsById;
    }

    @Override
    public String toString() {
        return "Filiere{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
