import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {
  autor: any = {nombres: 'Oscar Guillermo', apellidos: 'Sierra Lozano'}
  autor2: any = {nombres: 'Yeferson Esmid', apellidos: 'Heredia Perdomo'}
  autor3: any = {materia: 'Programación 3', grupo:'Grupo 2', universidad: '- Corhuila'}
}