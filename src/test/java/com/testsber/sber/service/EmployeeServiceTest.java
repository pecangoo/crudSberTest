package com.testsber.sber.service;

//
//class EmployeeServiceTest {
//
//    GoodsRepository employeeRepository = Mockito
//            .mock(GoodsRepository.class);
//    EmployeeService employeeService;
//    GoodsMapper goodsMapper = Mockito.mock(GoodsMapper.class);
//
//    @BeforeEach
//    void init() {
//        employeeService = new EmployeeService(employeeRepository);
//    }
//
//    @Test
//    public void saveGood() {
//
//        GoodEntity goodEntity = new GoodEntity()
//                .builder()
//                .id(null)
//                .price(1000l)
//                .category("123")
//                .description("1234")
//                .yearOfIssue(Date.valueOf(LocalDate.now()))
//                .build();
//
//        GoodDTO goodDTO = new GoodDTO()
//                .builder()
//                .id(null)
//                .price(1000l)
//                .category("123")
//                .description("1234")
//                .yearOfIssue(Date.valueOf(LocalDate.now()))
//                .build();
//        Mockito.when(GoodsMapper.toDto(goodEntity)).thenReturn(goodDTO);
//
//    }
//
//    @Test
//    void deleteById() {
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void getById() {
//    }
//}