import { Injectable } from '@angular/core';
import { map, Observable, of } from 'rxjs';
import { MarcasDeportivasc } from '../marcas_deportivas/marcas-deportivasc';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NikeService {

  private urlEndPoint:string='http://localhost:8080/api/nike'
  private httpHeaders = new HttpHeaders({'content-Type': 'application/json'})

  constructor(private http:HttpClient) { }

  //buscar tareas de la base de datos
  getNike():Observable<MarcasDeportivasc[]>{
    
    //return of (MarcasDeportivasc);
    return this.http.get(this.urlEndPoint).pipe(
     map((response)=> response as MarcasDeportivasc[])
    )
   }

  create(nike:MarcasDeportivasc): Observable<MarcasDeportivasc>{
    return this.http.post<MarcasDeportivasc>(this.urlEndPoint,nike, {headers:this.httpHeaders})
  }

  //Método de editar tarea
  getNikee(id: any):Observable<MarcasDeportivasc>{
    return this.http.get<MarcasDeportivasc>(`${this.urlEndPoint}/${id}`)
  }

  //Edición final
  update(nike: MarcasDeportivasc):Observable<MarcasDeportivasc>{
    return this.http.put<MarcasDeportivasc>(`${this.urlEndPoint}/${nike.id}`, nike, {headers:this.httpHeaders})
  }

  //Eliminar
  delete(id:number):Observable<MarcasDeportivasc>{
    return this.http.delete<MarcasDeportivasc>(`${this.urlEndPoint}/${id}`, {headers:this.httpHeaders})
  }
}