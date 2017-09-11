package projetodog.com.edu.projetodog.Fragment;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import projetodog.com.edu.projetodog.R;




    public class HomeFragment  extends Fragment implements MaterialTabListener {
        MaterialTabHost tabHost;
        ViewPager pager;
        ViewPagerAdapter pagerAdapter;
        private Resources res;
        private int[] tabIcons = {
                R.drawable.starwhite,

        };

        //utilizada para verificar se a tela existe
        boolean hasStop = false;

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_pagina_inicial, container, false);

            tabHost = (MaterialTabHost) view.findViewById(R.id.tabHost);
            pager = (ViewPager) view.findViewById(R.id.pager);

            // init view pager
            pagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
            pager.setAdapter(pagerAdapter);

            geraTabHost();
            return view;

        }




        public void geraTabHost(){

            if(!hasStop) {
                pager.setAdapter(pagerAdapter);
                pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // when user do a swipe the selected tab change
                        tabHost.setSelectedNavigationItem(position);

                    }
                });

                // insert all tabs from pagerAdapter data
                for (int i = 0; i < pagerAdapter.getCount(); i++) {
                    tabHost.addTab(
                            tabHost.newTab()
                                    .setText(pagerAdapter.getPageTitle(i))
                                    .setTabListener(this)
                    );

                }
            }

        }


        @Override
        public void onTabSelected(MaterialTab tab) {
            //Log.i("Script","tab.getPosition() = "+tab.getPosition());
            pager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabReselected(MaterialTab tab) {

        }

        @Override
        public void onTabUnselected(MaterialTab tab) {

        }

        private class ViewPagerAdapter extends FragmentStatePagerAdapter {

            public ViewPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            public Fragment getItem(int num) {

                Fragment frag = new FragmentTabMinhaLista();
                switch (num){
                    case 0:
                        frag = new FragmentTabMinhaLista();
                        break;
                    case 1:
                        frag = new FragmentTabTodos();
                        break;
                    case 2:
                        frag = new FragmentTabFavoritos();
                        break;
                }
                return frag;
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                //return "Sezione " + position;

                switch(position) {
                    case 0: return "Meus";
                    case 1: return "Todos";
                    case 2: return "Favoritos";
                    default: return "";
                }
            }
        }

      private Drawable getIcon(int position) {
            switch(position) {
                case 0:
                    return res.getDrawable(R.drawable.account);
                case 1:
                    return res.getDrawable(R.drawable.starwhite);
            }
            return null;
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            hasStop=true;
        }

    }


