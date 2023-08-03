package com.practica.usuarioservice.feignclients;

@FeignClient(name="auto-service",url="http://localhost:8002")
@RequestMapping("/auto")
public interface AutoFeignClient {

}
