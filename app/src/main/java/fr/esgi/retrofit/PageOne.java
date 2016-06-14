package fr.esgi.retrofit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageOne extends Fragment{

    public static PageOne newInstance(User user) {
        PageOne myFragment = new PageOne();

        Bundle args = new Bundle();
        args.putParcelable("USER", user);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_info, container, false);
        TextView textView = (TextView) view.findViewById(R.id.info_text);
        User user = getArguments().getParcelable("USER");
        String text;
        if (user != null) {
            text = getString(R.string.nb_repo) + user.getPublic_repos();
            textView.setText(text);
        }
        return view;
    }

}
