package web.pocs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jsonpractice.LoadJsonData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.pocs.service.ActorService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Data
@AllArgsConstructor
class Car {
    private int carNumber;
    private Engine engine;

    Car() {
        log.info("Inside car constructor");
    }
}

@Slf4j
@Data
@AllArgsConstructor
class Engine {
    private int chessyNumber;
    private Piston piston;
}

@Slf4j
@Data
@AllArgsConstructor
class Piston {
    private int numberOfPiston;
    private String name;
}


@Slf4j
@RestController
@RequestMapping
@SpringBootApplication
public class WebPocMainApplication {

    @Autowired
    ActorService actorService;

    @Bean
    public CommandLineRunner commmandLineRunner() {
        return args -> {
            log.info("RECORDS COUNT : {}", actorService.getTotalNumberOfRecords());
//            actorService.paginatedActor();
//            actorService.paginatedActorFromLib();
            actorService.getCustomPaginatedData();
        };
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Car car = new Car(3, new Engine(2, new Piston(4, "Jz")));
        System.out.println(gson.toJson(car));
        SpringApplication.run(WebPocMainApplication.class, args);
    }

    @PostMapping(value = "/nullCheck", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkingNullValue(@RequestBody Car car) {
        log.info("Car object {}", car);
        log.info("NPE: {}", Optional.of(car).map(Car::getEngine).map(Engine::getPiston).map(Piston::getName).orElse(""));
        return ResponseEntity.ok("");
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadingFile() throws IOException {

        File file = new LoadJsonData().loadingJsonData();
        InputStream inputStream = new FileInputStream(file.getAbsolutePath());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + UUID.randomUUID() + "." + file.getName().split("\\.")[1]);
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(inputStreamResource);
    }

}
