import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NikeService } from './nike.service';
import { MarcasDeportivasc } from '../marcas_deportivas/marcas-deportivasc';
import { RouterLink } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nike',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './nike.component.html',
  styleUrl: './nike.component.css'
})
export class NikeComponent implements OnInit{
  
  nike: MarcasDeportivasc[];

  constructor(private nikeservice: NikeService){
    
  }
  ngOnInit(): void {
    this.nikeservice.getNike().subscribe(
      nike => this.nike = nike
    )
  }

  //invocando el método de eliminar
  delete(nike:MarcasDeportivasc):void{
    Swal.fire({
      title: "Esta segur@?",
      text: `Seguro deseas eliminar Adidas: ${nike.nombre} !`,
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, Eliminar!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.nikeservice.delete(nike.id).subscribe(
          response=>{
            this.nike = this.nike.filter(tar=> tar !== nike)
            Swal.fire({
              title: "Borrada!",
              text: `Tu Tarea ha sido eliminada: ${nike.nombre}`,
              icon: "success"
            });
          }
        )
      }
    });
  }

}