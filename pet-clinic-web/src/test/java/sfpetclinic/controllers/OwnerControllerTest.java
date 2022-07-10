package sfpetclinic.controllers;

import controllers.ownersController;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import services.OwnerService;
import sfpetclinic.Model.Owner;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class OwnerControllerTest {
    @Mock
    OwnerService ownerService;

    @InjectMocks
    ownersController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();

        Owner own1= new Owner();
        own1.setId(1L);

        Owner own2= new Owner();
        own2.setId(2L);

        owners.add(own1);
        owners.add(own2);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));

        verifyNoInteractions(ownerService);
    }


    @Test
    void processFindFormReturnMany() throws Exception {

        List<Owner> owners= new ArrayList<>();

        Owner own1= new Owner();
        own1.setId(1L);

        Owner own2= new Owner();
        own2.setId(2L);

        owners.add(own1);
        owners.add(own2);

        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(owners);

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    void processFindFormReturnOne() throws Exception {

        List<Owner> owners= new ArrayList<>();

        Owner own1= new Owner();
        own1.setId(1L);
        owners.add(own1);


        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(owners);

        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
    }

    @Test
    void processFindFormEmptyReturnMany() throws Exception {
        List<Owner> owners= new ArrayList<>();

        Owner own1= new Owner();
        own1.setId(1L);

        Owner own2= new Owner();
        own2.setId(2L);

        owners.add(own1);
        owners.add(own2);

        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(owners);

        mockMvc.perform(get("/owners")
                        .param("lastName",""))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));;
    }

    @Test
    void displayOwner() throws Exception {
        Owner own1 = new Owner();
        own1.setId(1L);
        when(ownerService.findById(anyLong())).thenReturn(own1);

        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1l))));
    }


    @Test
    void initCreationForm() throws Exception {
        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

        verifyNoInteractions(ownerService);
    }

    @Test
    void processCreationForm() throws Exception {
        Owner own1 = new Owner();
        own1.setId(1L);
        when(ownerService.save(ArgumentMatchers.any())).thenReturn(own1);

        mockMvc.perform(post("/owners/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));

        verify(ownerService).save(ArgumentMatchers.any());
    }

    @Test
    void initUpdateOwnerForm() throws Exception {
        Owner own1 = new Owner();
        own1.setId(1L);
        when(ownerService.findById(anyLong())).thenReturn(own1);

        mockMvc.perform(get("/owners/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

       // verifyNoInteractions(ownerService);
    }

    @Test
    void processUpdateOwnerForm() throws Exception {
        Owner own1 = new Owner();
        own1.setId(1L);
        own1.setFirstName("temp");
        own1.setLastName("temp");

        when(ownerService.save(ArgumentMatchers.any())).thenReturn(own1);

        mockMvc.perform(post("/owners/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));

        verify(ownerService).save(ArgumentMatchers.any());
    }
}
