package ca.sheridancollege.su11.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.v1.FirestoreClient;
import com.google.firebase.FirebaseApp;

import ca.sheridancollege.su11.beans.Parent;

@Service
public class FirebaseService {
	
	private final Firestore firestore;
	
	public FirebaseService(Firestore firestore) {
		this.firestore = firestore;
	}
	
	public Parent addParent(Parent parent) {
		DocumentReference documentReference = firestore.collection("users").document();
		 parent.setId(documentReference.getId());
		 
		//save the parent object, including the id, to Firestore
		documentReference.set(parent);
		parent.setId(documentReference.getId());
		return parent;
	}
	
	public List<Parent> getAllParents() throws ExecutionException, InterruptedException {
        List<QueryDocumentSnapshot> documents = firestore.collection("users").get().get().getDocuments();
        List<Parent> parents = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            Parent parent = document.toObject(Parent.class);
            parent.setId(document.getId());
            parents.add(parent);
        }
        return parents;
    }
	
//	public String addParent(Parent parent) throws ExecutionException, InterruptedException {
//	    Map<String, Object> data = new HashMap<>();
//	    data.put("userName", parent.getUserName());
//	    data.put("password", parent.getPassword());
//	    data.put("firstName", parent.getFirstName());
//	    data.put("lastName", parent.getLastName());
//	    data.put("gender", parent.getGender());
//	    data.put("phone", parent.getPhone());
//	    data.put("email", parent.getEmail());
//	    data.put("address", parent.getAddress());
//
//	    DocumentReference addedDocRef = firestore.collection("Users").add(data).get();
//	    return addedDocRef.getId();
//	}
	
	
	
	
}
