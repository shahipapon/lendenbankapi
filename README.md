# lendenbankapi
 lenden payment gateway (testing purpose)

# All endpoints
1. path: "/"  \
   request "GET" \
   Output:  Dummy Text

2. path: "/giveall"  \
   request "GET" \
   Output:  Check all Data  

3. path: "/info/{id}"  \
   request "GET"\
   Input: htttps://..../info/1 \
   Output:  Check Bank Info By Id(1,2,3...)
 
4. path: "/bank/{name}"  \
        request "GET" \
        Input: htttps://..../bank/b1111 \
        Output:  Check Bank Info By bank user(b1111,b2222,b3333...)
    
5. path: "/addbank"  \
        request "POST" \
        Input( type- JSON ):\
        \
``` js
    { 
     "bankmoney": 14000.2132, 
     "bankno": "", 
     "bankpin": "", 
     "transaction": "", 
     "receiveraccount": null 
     }
```      
5. path: "/update"  \
        request "PUT" \
        Input( type- JSON ): Required id is must and others value for update is optional. But update field required must \
        \
 ``` js
     { 
      "id": anythiing //required id, 
      "bankmoney": anything,  // type double 
      "bankno": "Null or Anything ", 
      "bankpin": "Null or Anything ", 
      "transaction": "Null or Anything ", 
      "receiveraccount": Null or Anything  
    } 
```   
7. path: "/payment"  \
        request "PUT" \
        Input( type- JSON ): \
        Output( type- string ): \
        input:     \
        \
  ``` js
     { 
     "bankno": "Valid Bank No From Database" //must ex:b1111/b2222/... 
     "bankpin": "Valid Bank PIn No From Database" /must ex:1234 
     "transaction":  ///must (Invoice bill goes here) (type doube) 
     "receiveraccount": //must ex: (wholeseller account goes here) 
     }
```  
       
