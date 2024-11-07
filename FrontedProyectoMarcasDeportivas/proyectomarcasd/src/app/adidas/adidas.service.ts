import { Injectable } from '@angular/core';
import { map, Observable, of } from 'rxjs';
import { MarcasDeportivasc } from '../marcas_deportivas/marcas-deportivasc';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdidasService {
   private urlEndPoint:string='http://localhost:8080/api/adidas'
   private httpHeaders = new HttpHeaders({'content-Type': 'application/json'})

  constructor(private http:HttpClient) { }

  //buscar tareas de la base de datos
  getAdidas():Observable<MarcasDeportivasc[]>{
    
    //return of (MarcasDeportivasc);
    return this.http.get(this.urlEndPoint).pipe(
     map((response)=> response as MarcasDeportivasc[])
    )
   }

  create(adidas:MarcasDeportivasc): Observable<MarcasDeportivasc>{
    return this.http.post<MarcasDeportivasc>(this.urlEndPoint,adidas, {headers:this.httpHeaders})
  }

  //Método de editar tarea
  getAdida(id: any):Observable<MarcasDeportivasc>{
    return this.http.get<MarcasDeportivasc>(`${this.urlEndPoint}/${id}`)
  }

  //Edición final
  update(adidas: MarcasDeportivasc):Observable<MarcasDeportivasc>{
    return this.http.put<MarcasDeportivasc>(`${this.urlEndPoint}/${adidas.id}`, adidas, {headers:this.httpHeaders})
  }

  //Eliminar
  delete(id:number):Observable<MarcasDeportivasc>{
    return this.http.delete<MarcasDeportivasc>(`${this.urlEndPoint}/${id}`, {headers:this.httpHeaders})
  }
}