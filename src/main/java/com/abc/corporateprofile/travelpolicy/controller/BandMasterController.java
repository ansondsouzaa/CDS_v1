package com.abc.corporateprofile.travelpolicy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.corporateprofile.travelpolicy.dto.BandMaster;
import com.abc.corporateprofile.travelpolicy.excel.ResponseMessage;
import com.abc.corporateprofile.travelpolicy.service.BandServiceImpl;

@RestController
@RequestMapping(value = "/bands")
@CrossOrigin(origins = "http://localhost:4200")
public class BandMasterController {

	@Autowired
	BandServiceImpl bandservice;

	// BandMaster Master

	// Create BandMaster
	@PostMapping(value = "/addBand")
	public void addBand(@RequestBody BandMaster addBand) {
		bandservice.addBand(addBand);
	}

	// Retrieve BandMaster
	@GetMapping(value = "/listAllBandMasters")
	public ResponseEntity<List<BandMaster>> listAllBands() {
		try {
			List<BandMaster> bands = bandservice.listAllBands();
			if (bands.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(bands, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Update BandMaster
	@PostMapping(value = "/UpdateBandById")
	public ResponseEntity<ResponseMessage> UpdateBandById(@RequestParam("id") Integer id,
			@RequestParam("band_name") String band_name, @RequestParam("modified_by") Integer modified_by) {
		String message = "";
		try {
			bandservice.updateBandById(id, band_name, modified_by);
			message = "Updated successfully for band with id: " + id;
			System.out.println("Updated successfully for band with id: " + id);
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

		} catch (Exception e) {
			message = "Could not update the desired designation info with id: " + id + "!";
			System.out.println("Could not update the desired band info with id: " + id + "!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
		}
	}

	// Delete BandMaster
	@DeleteMapping("/deleteBandById/{id}")
	private void deleteBandById(@PathVariable("id") int id) {
		bandservice.deleteBandById(id);
	}

}
