package it.danielrrapi.U5W3D1.entities;

import it.danielrrapi.U5W3D1.enums.DispositivoStatus;
import it.danielrrapi.U5W3D1.enums.DispositivoType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "dispositivi")
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private long id;
    @Enumerated(EnumType.STRING)
    private DispositivoType tipo;
    @Enumerated(EnumType.STRING)
    private DispositivoStatus stato;
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public Dispositivo(DispositivoType tipo, DispositivoStatus stato, Dipendente dipendente) {
        this.tipo = tipo;
        this.stato = stato;
        this.dipendente = dipendente;
    }
}

