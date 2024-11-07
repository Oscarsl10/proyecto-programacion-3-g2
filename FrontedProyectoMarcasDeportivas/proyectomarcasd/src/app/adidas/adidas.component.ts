import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AdidasService } from './adidas.service';
import { MarcasDeportivasc } from '../marcas_deportivas/marcas-deportivasc';
import { RouterLink } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-adidas',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './adidas.component.html',
  styleUrl: './adidas.component.css'
})
export class AdidasComponent implements OnInit{
  
  adidas: MarcasDeportivasc[];

  constructor(private adidasService: AdidasService){

  }

  ngOnInit(): void {
    this.adidasService.getAdidas().subscribe(
      adidas => this.adidas = adidas
    )
  }

  //invocando el método de eliminar
  delete(adidas:MarcasDeportivasc):void{
    Swal.fire({
      title: "Esta segur@?",
      text: `Seguro deseas eliminar Adidas: ${adidas.nombre} !`,
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, Eliminar!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.adidasService.delete(adidas.id).subscribe(
          response=>{
            this.adidas = this.adidas.filter(tar=> tar !== adidas)
            Swal.fire({
              title: "Borrada!",
              text: `Tu Tarea ha sido eliminada: ${adidas.nombre}`,
              icon: "success"
            });
          }
        )
      }
    });
  }

}