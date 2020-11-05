package com.simplechain.webapp.backend.controllers.rest.v1;

import com.simplechain.webapp.backend.models.Block;
import com.simplechain.webapp.backend.repos.BlockRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("blocks")
public class BlockController {
    private final BlockRepo blockRepo;

    @Autowired
    public BlockController(BlockRepo blockRepo) {
        this.blockRepo = blockRepo;
    }

    @GetMapping
    public List<Block> getBlocks() {
        return blockRepo.findAll();
    }

    @GetMapping("{id}")
    public Block getOne(@PathVariable("id") Block block) {
        return block;
    }

    @PostMapping
    public Block addBlock(@RequestBody Block block) {
        block.setTimeStamp(String.valueOf(LocalDateTime.now()));
        return blockRepo.save(block);
    }

    @PutMapping("{id}")
    public Block update(@PathVariable("id") Block blockFromDb,
                          @RequestBody Block block) {
        BeanUtils.copyProperties(block, blockFromDb, "id");
        return blockRepo.save(blockFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteBlock(@PathVariable("id") Block block) {
        blockRepo.delete(block);
    }
}
