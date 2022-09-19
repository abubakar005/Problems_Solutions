package itsync;

public class Question3 {

    /**


     import org.springframework.data.jpa.repository.*;
     import org.springframework.http.HttpStatus;
     import org.springframework.http.MediaType;
     import org.springframework.transaction.annotation.*;
     import org.springframework.web.bind.annotation.*;

     import javax.persistence.*;
     import java.util.logging.Logger;

     import org.springframework.beans.factory.annotation.Autowired;
     import java.util.Optional;
     import org.springframework.http.HttpStatus;
     import org.springframework.http.ResponseEntity;

     @Entity
     @Table
     class Task {

     @Id
     private Long id;
     private String description;
     private Long priority;

     public Long getId() {
     return id;
     }

     public void setId(Long id) {
     this.id = id;
     }

     public String getDescription() {
     return description;
     }

     public void setDescription(String description) {
     this.description = description;
     }

     public Long getPriority() {
     return priority;
     }

     public void setPriority(Long priority) {
     this.priority = priority;
     }
     }

     @RestController
     @RequestMapping("/tasks")
     class TaskController {
     private static Logger log = Logger.getLogger("Solution");
     // log.info("You can use 'log' for debug messages");

     @Autowired
     private TaskRepository taskRepository;

     @PutMapping("/{id}")
     public Request updateTask(@RequestBody Request request, @PathVariable("id") Long id) {

     if(request.getDescription() == null || request.getDescription().isEmpty())
     throw new BadRequestException(Error.DESCRIPTION_IS_REQUIRED.getCode(), Error.DESCRIPTION_IS_REQUIRED.getMsg());

     Task task = taskRepository.findById(id).orElseThrow(()->new ElementNotFoundException(Error.TASK_NOT_FOUND.getCode(), Error.TASK_NOT_FOUND.getMsg()));

     task.setDescription(request.getDescription());
     task.setPriority(request.getPriority());
     taskRepository.save(task);

     return request;
     }
     }

     class Request {

     private String description;
     private Long priority;

     public String getDescription() {
     return description;
     }

     public void setDescription(String description) {
     this.description = description;
     }

     public Long getPriority() {
     return priority;
     }

     public void setPriority(Long priority) {
     this.priority = priority;
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

     interface TaskRepository extends JpaRepository<Task, Long> {

     }

     @RestControllerAdvice
     class ExceptionControllerAdvisor {

     @ResponseStatus(HttpStatus.BAD_REQUEST)
     @ExceptionHandler(BadRequestException.class)
     public ResponseEntity<Response> handleValidationException(BadRequestException exception) {
     return new ResponseEntity<>(new Response(exception.getMsg(), exception.getCode()), HttpStatus.BAD_REQUEST);
     }

     @ResponseStatus(HttpStatus.NOT_FOUND)
     @ExceptionHandler(ElementNotFoundException.class)
     public ResponseEntity<Response> handleNotFoundException(ElementNotFoundException exception) {
     return new ResponseEntity<>(new Response(exception.getMsg(), exception.getCode()), HttpStatus.NOT_FOUND);
     }
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

     class ElementNotFoundException extends RuntimeException {

     private static final long serialVersionUID = -5218143265247846948L;

     private int code;
     private String msg;

     public ElementNotFoundException(int code, String msg) {
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

     enum Error {

     TASK_NOT_FOUND(404, "Cannot find task with given id"),
     DESCRIPTION_IS_REQUIRED(400, "Task description is required"),
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



     */
}
