// package com.example.demo;


// import com.example.demo.entities.Route;
// import com.example.demo.entities.User;
// import com.example.demo.entities.WasteBin;
// import com.example.demo.repositories.RouteRepository;
// import com.example.demo.repositories.UserRepository;
// import com.example.demo.repositories.WasteBinRepository;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import io.swagger.v3.oas.models.OpenAPI;

// import com.example.demo.Service.RouteService;
// import com.example.demo.Service.UserService;
// import com.example.demo.Service.WasteBinService;
// import com.example.demo.configuration.SwaggerConfig;

// import org.junit.Before;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.transaction.annotation.Transactional;
// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageImpl;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;


// import java.io.File;
// import java.lang.reflect.Method;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;
// import java.util.Optional;


// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// @SpringBootTest
// @Transactional // Ensures that changes are rolled back after each test
// public class UserServiceTest {

//     private static final String LOG_FOLDER_PATH = "logs";
//     private static final String LOG_FILE_PATH = "logs/application.log";

//     @Autowired
//     private UserService userService;

//     @Autowired
//     private UserRepository userRepository;

//      @Autowired
//     private WasteBinService wasteBinService;

//     @Autowired
//     private WasteBinRepository wasteBinRepository;

//     @Autowired
//     private RouteService routeService;

//     @Autowired
//     private RouteRepository routeRepository;

    

    


//     @BeforeEach
//     public void setUp() {
//         userRepository.deleteAll();
//         wasteBinRepository.deleteAll(); 
//         routeRepository.deleteAll(); // Clear the database before each test
//     }

//     @Before
// public void setUps() {
//     MockitoAnnotations.initMocks(this);
// }
//     @Test
//     public void testCreateUser() {
//         User user = new User();
//         user.setUsername("TestUser");
//         user.setEmail("testuser@example.com");
//         user.setRole("ADMIN");
    
//         User savedUser = userService.saveUser(user);
    
//         assertNotNull(savedUser.getId());
//         assertEquals("TestUser", savedUser.getUsername());
//         assertEquals("testuser@example.com", savedUser.getEmail());
//         assertEquals("ADMIN", savedUser.getRole());
//     }

//     @Test
// public void testGetAllUsers() {
//     User user1 = new User();
//     user1.setUsername("User1");
//     user1.setEmail("user1@example.com");
//     user1.setRole("STAFF");
//     userService.saveUser(user1);

//     User user2 = new User();
//     user2.setUsername("User2");
//     user2.setEmail("user2@example.com");
//     user2.setRole("DRIVER");
//     userService.saveUser(user2);

//     List<User> users = userService.getAllUsers();

//     assertTrue(users.size() >= 2);
//     assertTrue(users.stream().anyMatch(u -> u.getUsername().equals("User1")));
//     assertTrue(users.stream().anyMatch(u -> u.getUsername().equals("User2")));
// }
// @Test
// public void testUpdateUser() {
//     User user = new User();
//     user.setUsername("UpdateUser");
//     user.setEmail("updateuser@example.com");
//     user.setRole("STAFF");

//     User savedUser = userService.saveUser(user);

//     savedUser.setUsername("UpdatedUser");
//     savedUser.setEmail("updateduser@example.com");
//     User updatedUser = userService.saveUser(savedUser);

//     assertEquals("UpdatedUser", updatedUser.getUsername());
//     assertEquals("updateduser@example.com", updatedUser.getEmail());
//     assertEquals("STAFF", updatedUser.getRole());
// }
// @Test
// public void testDeleteUser() {
//     User user = new User();
//     user.setUsername("DeleteUser");
//     user.setEmail("deleteuser@example.com");
//     user.setRole("DRIVER");

//     User savedUser = userService.saveUser(user);

//     userRepository.deleteById(savedUser.getId());

//     Optional<User> deletedUser = userRepository.findById(savedUser.getId());
//     assertTrue(deletedUser.isEmpty());
// }
// @Test
// public void testGetUserById() {
//     User user = new User();
//     user.setUsername("GetByIdUser");
//     user.setEmail("getbyiduser@example.com");
//     user.setRole("ADMIN");

//     User savedUser = userService.saveUser(user);

//     Optional<User> retrievedUser = userRepository.findById(savedUser.getId());

//     assertTrue(retrievedUser.isPresent());
//     assertEquals("GetByIdUser", retrievedUser.get().getUsername());
//     assertEquals("getbyiduser@example.com", retrievedUser.get().getEmail());
//     assertEquals("ADMIN", retrievedUser.get().getRole());
// }
// @Test
//     public void testCreateWasteBin() {
//         User user = new User();
//         user.setUsername("User1");
//         user.setEmail("user1@example.com");
//         user.setRole("ADMIN");
//         User savedUser = userRepository.save(user);

//         WasteBin wasteBin = new WasteBin();
//         wasteBin.setLocation("Park");
//         wasteBin.setFillLevel(50);
//         wasteBin.setMalfunctioning(false);
//         wasteBin.setUser(savedUser);

//         WasteBin savedWasteBin = wasteBinService.saveWasteBin(wasteBin);

//         assertNotNull(savedWasteBin.getId());
//         assertEquals("Park", savedWasteBin.getLocation());
//         assertEquals(50, savedWasteBin.getFillLevel());
//         assertFalse(savedWasteBin.isMalfunctioning());
//         assertEquals(savedUser.getId(), savedWasteBin.getUser().getId());
//     }

//     @Test
//     public void testGetAllWasteBins() {
//         User user = new User();
//         user.setUsername("User2");
//         user.setEmail("user2@example.com");
//         user.setRole("USER");
//         User savedUser = userRepository.save(user);

//         WasteBin wasteBin1 = new WasteBin();
//         wasteBin1.setLocation("Mall");
//         wasteBin1.setFillLevel(30);
//         wasteBin1.setMalfunctioning(false);
//         wasteBin1.setUser(savedUser);

//         WasteBin wasteBin2 = new WasteBin();
//         wasteBin2.setLocation("School");
//         wasteBin2.setFillLevel(70);
//         wasteBin2.setMalfunctioning(true);
//         wasteBin2.setUser(savedUser);

//         wasteBinService.saveWasteBin(wasteBin1);
//         wasteBinService.saveWasteBin(wasteBin2);

//         List<WasteBin> wasteBins = wasteBinService.getAllWasteBins();

//         assertEquals(2, wasteBins.size());
//     }

//     @Test
//     public void testUpdateWasteBin() {
//         User user = new User();
//         user.setUsername("User3");
//         user.setEmail("user3@example.com");
//         user.setRole("USER");
//         User savedUser = userRepository.save(user);

//         WasteBin wasteBin = new WasteBin();
//         wasteBin.setLocation("Beach");
//         wasteBin.setFillLevel(40);
//         wasteBin.setMalfunctioning(false);
//         wasteBin.setUser(savedUser);

//         WasteBin savedWasteBin = wasteBinService.saveWasteBin(wasteBin);

//         savedWasteBin.setLocation("Updated Beach");
//         savedWasteBin.setFillLevel(60);
//         savedWasteBin.setMalfunctioning(true);

//         WasteBin updatedWasteBin = wasteBinService.saveWasteBin(savedWasteBin);

//         assertEquals("Updated Beach", updatedWasteBin.getLocation());
//         assertEquals(60, updatedWasteBin.getFillLevel());
//         assertTrue(updatedWasteBin.isMalfunctioning());
//     }

//     @Test
//     public void testDeleteWasteBin() {
//         User user = new User();
//         user.setUsername("User4");
//         user.setEmail("user4@example.com");
//         user.setRole("USER");
//         User savedUser = userRepository.save(user);

//         WasteBin wasteBin = new WasteBin();
//         wasteBin.setLocation("City Center");
//         wasteBin.setFillLevel(20);
//         wasteBin.setMalfunctioning(false);
//         wasteBin.setUser(savedUser);

//         WasteBin savedWasteBin = wasteBinService.saveWasteBin(wasteBin);

//         wasteBinRepository.deleteById(savedWasteBin.getId());

//         assertFalse(wasteBinRepository.findById(savedWasteBin.getId()).isPresent());
//     }

//     @Test
//     public void testFindWasteBinById() {
//         User user = new User();
//         user.setUsername("User5");
//         user.setEmail("user5@example.com");
//         user.setRole("USER");
//         User savedUser = userRepository.save(user);

//         WasteBin wasteBin = new WasteBin();
//         wasteBin.setLocation("Market");
//         wasteBin.setFillLevel(90);
//         wasteBin.setMalfunctioning(true);
//         wasteBin.setUser(savedUser);

//         WasteBin savedWasteBin = wasteBinService.saveWasteBin(wasteBin);

//         WasteBin foundWasteBin = wasteBinRepository.findById(savedWasteBin.getId()).orElse(null);

//         assertNotNull(foundWasteBin);
//         assertEquals(savedWasteBin.getId(), foundWasteBin.getId());
//     }

//     @Test
//     public void testCreateRoute() {
//         User user = new User();
//         user.setUsername("User1");
//         user.setEmail("user1@example.com");
//         user.setRole("ADMIN");
//         User savedUser = userRepository.save(user);

//         Route route = new Route();
//         route.setRouteName("Route A");
//         route.setPath("Path A");
//         route.setUser(savedUser);

//         Route savedRoute = routeService.saveRoute(route);

//         assertNotNull(savedRoute.getId());
//         assertEquals("Route A", savedRoute.getRouteName());
//         assertEquals("Path A", savedRoute.getPath());
//         assertEquals(savedUser.getId(), savedRoute.getUser().getId());
//     }

//     @Test
//     public void testGetAllRoutes() {
//         User user = new User();
//         user.setUsername("User2");
//         user.setEmail("user2@example.com");
//         user.setRole("USER");
//         User savedUser = userRepository.save(user);

//         Route route1 = new Route();
//         route1.setRouteName("Route B");
//         route1.setPath("Path B");
//         route1.setUser(savedUser);

//         Route route2 = new Route();
//         route2.setRouteName("Route C");
//         route2.setPath("Path C");
//         route2.setUser(savedUser);

//         routeService.saveRoute(route1);
//         routeService.saveRoute(route2);

//         List<Route> routes = routeService.getAllRoutes();

//         assertEquals(2, routes.size());
//     }

//     @Test
//     public void testUpdateRoute() {
//         User user = new User();
//         user.setUsername("User3");
//         user.setEmail("user3@example.com");
//         user.setRole("USER");
//         User savedUser = userRepository.save(user);

//         Route route = new Route();
//         route.setRouteName("Route D");
//         route.setPath("Path D");
//         route.setUser(savedUser);

//         Route savedRoute = routeService.saveRoute(route);

//         savedRoute.setRouteName("Updated Route D");
//         savedRoute.setPath("Updated Path D");

//         Route updatedRoute = routeService.saveRoute(savedRoute);

//         assertEquals("Updated Route D", updatedRoute.getRouteName());
//         assertEquals("Updated Path D", updatedRoute.getPath());
//     }

//     @Test
//     public void testDeleteRoute() {
//         User user = new User();
//         user.setUsername("User4");
//         user.setEmail("user4@example.com");
//         user.setRole("USER");
//         User savedUser = userRepository.save(user);

//         Route route = new Route();
//         route.setRouteName("Route E");
//         route.setPath("Path E");
//         route.setUser(savedUser);

//         Route savedRoute = routeService.saveRoute(route);

//         routeRepository.deleteById(savedRoute.getId());

//         assertFalse(routeRepository.findById(savedRoute.getId()).isPresent());
//     }

//     @Test
//     public void testFindRouteById() {
//         User user = new User();
//         user.setUsername("User5");
//         user.setEmail("user5@example.com");
//         user.setRole("USER");
//         User savedUser = userRepository.save(user);

//         Route route = new Route();
//         route.setRouteName("Route F");
//         route.setPath("Path F");
//         route.setUser(savedUser);

//         Route savedRoute = routeService.saveRoute(route);

//         Route foundRoute = routeRepository.findById(savedRoute.getId()).orElse(null);

//         assertNotNull(foundRoute);
//         assertEquals(savedRoute.getId(), foundRoute.getId());
//         assertEquals("Route F", foundRoute.getRouteName());
//     }

//     @Test
//     public void testUserWithRoutesMapping() {
//         User user = new User();
//         user.setUsername("User1");
//         user.setEmail("user1@example.com");
//         user.setRole("Admin");

//         User savedUser = userRepository.save(user);

//         Route route1 = new Route(null, "Route A", "Path A", savedUser);
//         Route route2 = new Route(null, "Route B", "Path B", savedUser);

//         routeRepository.saveAll(Arrays.asList(route1, route2));

//         User foundUser = userRepository.findById(savedUser.getId()).orElse(null);

//         assertNotNull(foundUser);
//         assertEquals(2, routeRepository.findAll().stream()
//                 .filter(route -> route.getUser().getId().equals(savedUser.getId())).count());
//     }

//     @Test
//     public void testUserWithWasteBinsMapping() {
//         User user = new User();
//         user.setUsername("User2");
//         user.setEmail("user2@example.com");
//         user.setRole("User");

//         User savedUser = userRepository.save(user);

//         WasteBin wasteBin1 = new WasteBin(null, "Location A", 50, false, savedUser);
//         WasteBin wasteBin2 = new WasteBin(null, "Location B", 80, true, savedUser);

//         wasteBinRepository.saveAll(Arrays.asList(wasteBin1, wasteBin2));

//         User foundUser = userRepository.findById(savedUser.getId()).orElse(null);

//         assertNotNull(foundUser);
//         assertEquals(2, wasteBinRepository.findAll().stream()
//                 .filter(wasteBin -> wasteBin.getUser().getId().equals(savedUser.getId())).count());
//     }

//     @Test
//     public void testRouteBelongsToUserMapping() {
//         User user = new User();
//         user.setUsername("User3");
//         user.setEmail("user3@example.com");
//         user.setRole("Admin");

//         User savedUser = userRepository.save(user);

//         Route route = new Route(null, "Route C", "Path C", savedUser);
//         Route savedRoute = routeRepository.save(route);

//         assertNotNull(savedRoute);
//         assertEquals(savedUser.getId(), savedRoute.getUser().getId());
//     }

//     @Test
//     public void testWasteBinBelongsToUserMap() {
//         User user = new User();
//         user.setUsername("User4");
//         user.setEmail("user4@example.com");
//         user.setRole("User");

//         User savedUser = userRepository.save(user);

//         WasteBin wasteBin = new WasteBin(null, "Location C", 90, false, savedUser);
//         WasteBin savedWasteBin = wasteBinRepository.save(wasteBin);

//         assertNotNull(savedWasteBin);
//         assertEquals(savedUser.getId(), savedWasteBin.getUser().getId());
//     }

//     @Test
// public void testFindAllRoutesForUserMapping() {
//     User user = new User();
//     user.setUsername("User5");
//     user.setEmail("user5@example.com");
//     user.setRole("User");

//     User savedUser = userRepository.save(user);

//     Route route1 = new Route(null, "Route D", "Path D", savedUser);
//     Route route2 = new Route(null, "Route E", "Path E", savedUser);

//     routeRepository.saveAll(Arrays.asList(route1, route2));

//     List<Route> routes = routeRepository.findAll();

//     // Using a traditional loop to collect userRoutes
//     int userRouteCount = 0;
//     for (Route route : routes) {
//         if (route.getUser().getId().equals(savedUser.getId())) {
//             userRouteCount++;
//         }
//     }

//     assertEquals(2, userRouteCount);
// }

//  @Test
//     public void testJsonIgnoreOnWasteBins() throws Exception {
//         // Create a User object
//         User user = new User();
//         user.setId(1L);
//         user.setUsername("testuser");
//         user.setEmail("testuser@example.com");
//         user.setRole("Admin");

//         // Add dummy WasteBin data
//         user.setWasteBins(Collections.emptyList());

//         // Serialize the User object to JSON
//         ObjectMapper objectMapper = new ObjectMapper();
//         String jsonString = objectMapper.writeValueAsString(user);

//         // Assert that the wasteBins field is not present in the JSON string
//         assertFalse(jsonString.contains("wasteBins"));
//         assertTrue(jsonString.contains("username"));
//         assertTrue(jsonString.contains("email"));
//         assertTrue(jsonString.contains("role"));
//     }

//     @Test
//     void Annotation_testWasteBinHasJsonIgnoreAnnotations() throws Exception {
//         // Path to the WasteBin entity file
//         Path entityFilePath = Paths.get("src/main/java/com/example/demo/entities/WasteBin.java");

//         // Read the content of the entity file as a string
//         String entityFileContent = Files.readString(entityFilePath);

//         // Assert that the file contains @JsonIgnore annotation
//         assertTrue(entityFileContent.contains("@JsonIgnore"), "WasteBin entity should contain @JsonIgnore annotation");
//     }

//     @Test
//     void testRouteRepositoryExists() {
//         // Path to the RouteRepository file
//         Path filePath = Paths.get("src/main/java/com/example/demo/repositories/RouteRepository.java");

//         // Check if the file exists
//         assertTrue(Files.exists(filePath), "RouteRepository file should exist in the specified path");
//     }

//     @Test
//     void testUserRepositoryExists() {
//         // Path to the UserRepository file
//         Path filePath = Paths.get("src/main/java/com/example/demo/repositories/UserRepository.java");

//         // Check if the file exists
//         assertTrue(Files.exists(filePath), "UserRepository file should exist in the specified path");
//     }

//     @Test
//     void testWasteBinRepositoryExists() {
//         // Path to the WasteBinRepository file
//         Path filePath = Paths.get("src/main/java/com/example/demo/repositories/WasteBinRepository.java");

//         // Check if the file exists
//         assertTrue(Files.exists(filePath), "WasteBinRepository file should exist in the specified path");
//     }

//     @Test
//     public void SwaggerUI_testConfigurationFolder() {
//         String directoryPath = "src/main/java/com/example/demo/configuration"; // Replace with the path to your directory
//         File directory = new File(directoryPath);
//         assertTrue(directory.exists() && directory.isDirectory(), "The specified configuration folder should exist and be a directory.");
//     }
 
//     @Test
//     public void SwaggerUI_testCustomOpenAPIBeanCreation() {
//         AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwaggerConfig.class);
//         OpenAPI openAPI = context.getBean(OpenAPI.class);
 
//         assertNotNull(openAPI, "OpenAPI bean should not be null.");
//         Info info = openAPI.getInfo();
//         assertNotNull(info, "OpenAPI Info should not be null.");
//         assertEquals("My API", info.getTitle(), "API title should match the expected value.");
//         assertEquals("1.0", info.getVersion(), "API version should match the expected value.");
//         assertEquals("API documentation using Swagger", info.getDescription(), "API description should match the expected value.");
//         context.close();
//     }
 
//     @Test
//     public void SwaggerUI_testCustomOpenAPIMethodIsAnnotatedWithBean() throws NoSuchMethodException {
//         Method method = SwaggerConfig.class.getDeclaredMethod("customOpenAPI");
//         Bean beanAnnotation = method.getAnnotation(Bean.class);
//         assertTrue(beanAnnotation != null, "customOpenAPI method should be annotated with @Bean.");
//     }
 
//     @Test
//     public void SwaggerUI_testConfigurationAnnotation() {
//         Configuration configurationAnnotation = SwaggerConfig.class.getAnnotation(Configuration.class);
//         assertTrue(configurationAnnotation != null, "SwaggerConfig should be annotated with @Configuration.");
//     }
//     @Test
//     public void Log_testLogFolderAndFileCreation() {
//         // Check if the "logs" folder exists
//         File logFolder = new File(LOG_FOLDER_PATH);
//         assertTrue(logFolder.exists(), "Log folder should be created");
 
//         // Check if the "application.log" file exists inside the "logs" folder
//         File logFile = new File(LOG_FILE_PATH);
//         assertTrue(logFile.exists(), "Log file should be created inside 'logs' folder");
//     }

//     @Test
//     void AOP_testAOPConfigFile() {
//         // Path to the LoggingAspect class file
//         String filePath = "src/main/java/com/example/demo/aspect/LoggingAspect.java";

//         // Create a File object
//         File file = new File(filePath);

//         // Assert that the file exists and is a valid file
//         assertTrue(file.exists() && file.isFile(), "LoggingAspect.java file should exist at the specified path.");
//     }

//     @Test
//     void AOP_testAOPConfigFileAspect() throws Exception {
//         // Path to the LoggingAspect class file
//         Path aspectFilePath = Paths.get("src/main/java/com/example/demo/aspect/LoggingAspect.java");

//         // Read the content of the aspect file
//         String aspectFileContent = Files.readString(aspectFilePath);

//         // Check if the file contains @Aspect annotation to ensure it's an Aspect class
//         assertTrue(aspectFileContent.contains("@Aspect"), "The LoggingAspect.java should be annotated with @Aspect.");

//         // Check if the file contains the logger definition to ensure logging functionality is implemented
//         assertTrue(aspectFileContent.contains("private static final Logger logger"), "The LoggingAspect.java should define a logger for logging.");
//     }

//     @Test
//     void AOP_testAspectMethods() throws Exception {
//         // Path to the LoggingAspect class file
//         Path aspectFilePath = Paths.get("src/main/java/com/example/demo/aspect/LoggingAspect.java");

//         // Read the content of the aspect file
//         String aspectFileContent = Files.readString(aspectFilePath);

//         // Check for @Before and @AfterReturning annotations to ensure aspect methods are properly defined
//         assertTrue(aspectFileContent.contains("@Before"), "@Before annotation should be present in the LoggingAspect.java");
//         assertTrue(aspectFileContent.contains("@AfterReturning"), "@AfterReturning annotation should be present in the LoggingAspect.java");
//     }

//     @Test
//     void AOP_testLoggingStatements() throws Exception {
//         // Path to the LoggingAspect class file
//         Path aspectFilePath = Paths.get("src/main/java/com/example/demo/aspect/LoggingAspect.java");

//         // Read the content of the aspect file
//         String aspectFileContent = Files.readString(aspectFilePath);

//         // Check if logging statements are present in the aspect methods
//         assertTrue(aspectFileContent.contains("logger.info"), "The LoggingAspect.java should contain logger.info statements for logging.");
//     }

//     @Test
// public void JPQL_testGetUserByUsername() {
//     // Arrange: Create and save a user
//     User user = new User();
//     user.setUsername("User1");
//     user.setEmail("user1@example.com");
//     user.setRole("Admin");
//     user = userRepository.save(user);

//     // Act: Use the service method to find user by username
//     User result = userService.getUserByUsername("User1");

//     // Optionally print the result for debugging
//     System.out.println("User: " + result);

//     // Assert: Check if the user was found and its username matches
//     assertNotNull(result, "User should not be null");
//     assertEquals("User1", result.getUsername(), "User name should be 'User1'");
//     assertEquals("user1@example.com", result.getEmail(), "User email should be 'user1@example.com'");
//     assertEquals("Admin", result.getRole(), "User role should be 'Admin'");
// }

// @Test
// public void JPQL_testSearchWasteBinsByLocation() {
//     // Arrange: Create and save some waste bins
//     WasteBin wasteBin1 = new WasteBin();
//     wasteBin1.setLocation("Park");
//     wasteBin1.setFillLevel(80);
//     wasteBin1.setMalfunctioning(false);
//     wasteBinRepository.save(wasteBin1);

//     WasteBin wasteBin2 = new WasteBin();
//     wasteBin2.setLocation("Mall");
//     wasteBin2.setFillLevel(65);
//     wasteBin2.setMalfunctioning(true);
//     wasteBinRepository.save(wasteBin2);

//     // Act: Search waste bins by location
//     List<WasteBin> result = wasteBinService.searchWasteBinsByLocation("Park");

//     System.out.println("WasteBins found: " + result.size());

//     // Check if there are any results
//     if (result.size() > 0) {
//         System.out.println("WasteBins that match 'Park':");
//         for (WasteBin wasteBin : result) {
//             System.out.println("WasteBin Location: " + wasteBin.getLocation());
//             System.out.println("Fill Level: " + wasteBin.getFillLevel());
//             System.out.println("Malfunctioning: " + wasteBin.isMalfunctioning());
//         }
//     } else {
//         System.out.println("No waste bins found with the location 'Park'");
//     }
// }

// @Test
// public void PaginateSorting_testGetWasteBinsPagination() {
//     // Arrange: Create a Pageable object for pagination (first page, 10 items per page)
//     Pageable pageable = PageRequest.of(0, 10);

//     // Create sample WasteBin objects
//     WasteBin wasteBin1 = new WasteBin();
//     wasteBin1.setLocation("Location 1");
//     WasteBin wasteBin2 = new WasteBin();
//     wasteBin2.setLocation("Location 2");

//     // Create a Page object containing the WasteBin objects
//     Page<WasteBin> wasteBinPage = new PageImpl<>(Arrays.asList(wasteBin1, wasteBin2), pageable, 2);

//     // Correctly mock the repository call
// // This is just for testing purposes - do not use this in production code.

//     // Act: Call the service method to get waste bins with pagination
//     Page<WasteBin> result = wasteBinService.getWasteBins(0, 10);

//     // Print the result to the console (optional for debugging)
//     System.out.println("Total waste bins found: " + result.getTotalElements());
//     System.out.println("Number of waste bins on this page: " + result.getContent().size());

//     // Print out the details of the waste bins
//     for (WasteBin wasteBin : result.getContent()) {
//         System.out.println("Waste Bin Location: " + wasteBin.getLocation());
//     }

//     // Verify that the repository method was called with the correct Pageable
// }








// }




   
    

