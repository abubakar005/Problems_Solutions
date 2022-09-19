package itsync;

public class Question2 {

    /**


     import org.springframework.web.bind.annotation.*;
     import org.springframework.web.bind.annotation.RestController;
     import org.springframework.http.MediaType;

     import com.fasterxml.jackson.annotation.JsonInclude;

     import java.time.ZoneOffset;
     import java.time.ZonedDateTime;
     import java.time.format.DateTimeFormatter;
     import org.springframework.http.ResponseEntity;
     import org.springframework.http.HttpStatus;
     import java.io.Serializable;
     import org.springframework.http.MediaType;

     import org.springframework.http.HttpStatus;
     import org.springframework.http.ResponseEntity;


     @RestController
     class HealthcheckController {

     // Your solution
     @GetMapping("/healthcheck")
     @ResponseBody
     public ResponseEntity<HealthCareStatus> healthCare(@RequestParam(name = "format", required = false) String inputFormat) {

     if(inputFormat==null || (!inputFormat.equals("full") && !inputFormat.equals("short"))) {
     throw new BadRequestException(Error.FORMAT_IS_REQUIRED.getCode(), Error.FORMAT_IS_REQUIRED.getMsg());
     }

     if(inputFormat.equals("short"))
     return ResponseEntity.ok(new HealthCareStatus("OK", null));
     else if(inputFormat.equals("full"))
     return ResponseEntity.ok(new HealthCareStatus("OK", ZonedDateTime.now( ZoneOffset.UTC ).format( DateTimeFormatter.ISO_INSTANT )));

     return null;
     }

     @JsonInclude(JsonInclude.Include.NON_NULL)
     private class HealthCareStatus implements Serializable {

     private String currentTime;
     private String status;

     public HealthCareStatus(String status, String currentTime) {
     this.status = status;
     this.currentTime = currentTime;
     }

     public String getCurrentTime() {
     return currentTime;
     }

     public String getStatus() {
     return status;
     }

     }

     @PutMapping(value = "/healthcheck")
     @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
     public void healthcheckPut() {
     return;
     }

     @PostMapping(value = "/healthcheck")
     @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
     public void healthcheckPost() {
     return;
     }

     @DeleteMapping(value = "/healthcheck")
     @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
     public void healthcheckDelete() {
     return;
     }


     class BadRequestException extends RuntimeException {

     private static final long serialVersionUID = 6171978443681353425L;

     private int code;
     private String msg;

     public BadRequestException(int code, String msg) {
     this.code = code;
     this.msg = msg;
     }

     public int getCode() {
     return code;
     }

     public String getMsg() {
     return msg;
     }
     }

     class Response {

     private String message;
     private int status;

     public Response(String message, int status) {
     this.message = message;
     this.status = status;
     }

     public String getMessage() {
     return message;
     }

     public void setMessage(String message) {
     this.message = message;
     }

     public int getStatus() {
     return status;
     }

     public void setStatus(int status) {
     this.status = status;
     }
     }

     @RestControllerAdvice
     class ExceptionControllerAdvisor {

     @ResponseStatus(HttpStatus.BAD_REQUEST)
     @ExceptionHandler(BadRequestException.class)
     public ResponseEntity<Response> handleValidationException(BadRequestException exception) {
     return new ResponseEntity<>(new Response(exception.getMsg(), exception.getCode()), HttpStatus.BAD_REQUEST);
     }
     }

     enum Error {

     FORMAT_IS_REQUIRED(400, "Bad Request"),
     ;

     private final int code;
     private final String msg;

     Error(int code, String msg) {
     this.code = code;
     this.msg = msg;
     }

     public String getMsg() {
     return msg;
     }

     public int getCode() {
     return code;
     }
     }

     }



     */
}
