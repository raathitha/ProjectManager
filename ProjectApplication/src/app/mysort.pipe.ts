import { Pipe, PipeTransform } from '@angular/core';

import {FormsModule}        from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Pipe({
  name: 'mysort'
})
export class MysortPipe implements PipeTransform {
transform( array: Array<any>, orderField: any, orderType: boolean ): Array<any> {
            
			if ((orderField=='employee_id' || orderField=='priority') && array !== undefined) {

				array.sort((a: any, b: any) => {
					let ax = a[ orderField ];
					let bx = b[ orderField ];
				  if (ax < bx) {
					return -1;
				  } else if (ax > bx) {
					return 1;
				  } else {
					return 0;
				  }
				});
				return array;
			}else if (array !== undefined) {

				array.sort( ( a: any, b: any ) => {
					let ae = a[ orderField ];
					let be = b[ orderField ];
					if ( ae == undefined && be == undefined ) return 0;
					if ( ae == undefined && be != undefined ) return orderType ? 1 : -1;
					if ( ae != undefined && be == undefined ) return orderType ? -1 : 1;
					if ( ae == be ) return 0;
					return orderType ? (ae.toString().toLowerCase() > be.toString().toLowerCase() ? -1 : 1) : (be.toString().toLowerCase() > ae.toString().toLowerCase() ? -1 : 1);
				} );
				return array;
			}
  }

}
