package br.com.locar.core;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.locar.core.R;
import br.com.locar.core.R.id;
import br.com.locar.core.R.layout;
import br.com.locar.core.R.menu;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MapActivity extends Activity {
	
	private GoogleMap map;
	private Marker mark1;
	private Marker mark2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		 map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
         map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
         final LatLng car1 = new LatLng(-15.8345115, -47.9114273);
         mark1 = map.addMarker(new MarkerOptions().position(car1).title("Fusca").snippet("Fusca Amarelo 1990 \n ALUGAR").
        		 icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
         
         final LatLng car2 = new LatLng(-10.4387497, -37.1732957);
         mark2 = map.addMarker(new MarkerOptions().position(car2).title("Gol").snippet("Gol Branco 2012 \n ALUGAR").
        		 icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
         
         
         map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			@Override
			public void onInfoWindowClick(Marker arg0) {
				if (arg0.equals(mark1)) {
					mark1.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
					mark1.setSnippet("ALUGADO!");
				}
				
				else if (arg0.equals(mark2)) {
					mark2.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
					mark2.setSnippet("ALUGADO!");
				}
				
			}
        	 
         });

         //map.moveCamera(CameraUpdateFactory.newLatLngZoom(car1,17));
         //map.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
