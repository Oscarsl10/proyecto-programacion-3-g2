import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PumaService } from './puma.service';
import { MarcasDeportivasc } from '../marcas_deportivas/marcas-deportivasc';
import { RouterLink } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-puma',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './puma.component.html',
  styleUrl: './puma.component.css'
})
export class PumaComponent implements OnInit{

  puma: MarcasDeportivasc[];

  constructor (private pumaService : PumaService){
    
  }
  ngOnInit(): void {
    this.pumaService.getPuma().subscribe(
      puma => this.puma = puma
    )
  }

  //invocando el método de eliminar
  delete(puma:MarcasDeportivasc):void{
    Swal.fire({
      title: "Esta segur@?",
      text: `Seguro deseas eliminar Adidas: ${puma.nombre} !`,
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, Eliminar!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.pumaService.delete(puma.id).subscribe(
          response=>{
            this.puma = this.puma.filter(tar=> tar !== puma)
            Swal.fire({
              title: "Borrada!",
              text: `Tu Tarea ha sido eliminada: ${puma.nombre}`,
              icon: "success"
            });
          }
        )
      }
    });

  }
}