package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Information;
import com.squareup.picasso.Picasso;

public class Infor_Adapter extends  RecyclerView.Adapter<Infor_Adapter.InforViewHolder>{
    private Context mContext;
    private Information infor;

    public Infor_Adapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(Information info){
        this.infor = info;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public InforViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_infor,parent,false);
        return new InforViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InforViewHolder holder, int position) {
        if (infor==null){
            return;
        }
        Picasso.with(mContext)
                .load(infor.getUrl())
                .into(holder.imgItemInfor);
        holder.tvItemInforId.setText("ID  :  "+infor.getId());
        holder.tvItemInforBreedsId.setText("Breeds ID  :  "+infor.getBreeds_id());
        holder.tvItemInforWeight.setText("Weight  :"+"    Imperial : "+infor.getWeight_imperial()+" | Metric : "+infor.getGetWeight_metric());
        holder.tvItemInforName.setText("Name  :  "+infor.getBreeds_name());
        holder.tvItemInforCfaUrl.setText("CFA Url  :  "+infor.getCfa_url());
        holder.tvItemInforVetstreetUrl.setText("Vetstreet Url  :  "+infor.getVetstreet_url());
        holder.tvItemInforVcahospitalsUrl.setText("VCA Hospitals Url  :  "+infor.getVcahospitals_url());
        holder.tvItemInforTemperament.setText("Temperament  :  "+infor.getTemperament());
        holder.tvItemInforOrigin.setText("Origin  :  "+infor.getOrigin());
        holder.tvItemInforCountryCodes.setText("Country Codes  :  "+infor.getCountry_codes());
        holder.tvItemInforCountryCode.setText("Country Code  :  "+infor.getCountry_code());
        holder.tvItemInforDescription.setText("Description  :  "+infor.getDescription());
        holder.tvItemInforLifeSpan.setText("Life Span  :  "+infor.getLife_span());
        holder.tvItemInforIndoor.setText("Indoor :  "+infor.getIndoor());
        holder.tvItemInforLap.setText("Lap :  "+infor.getLap());
        holder.tvItemInforAdaptability.setText("Adaptability :  "+infor.getAdaptability());
        holder.tvItemInforAffectionLevel.setText("Affection Level :  "+infor.getAffection_level());
        holder.tvItemInforChildFriendly.setText("Child Friendly :  "+infor.getChild_friendly());
        holder.tvItemInforCatFriendly.setText("Cat Friendly :  "+infor.getCat_friendly());
        holder.tvItemInforDogFriendly.setText("Dog Friendly :  "+infor.getDog_friendly());
        holder.tvItemInforEnergyLevel.setText("Energy Level :  "+infor.getEnergy_level());
        holder.tvItemInforGrooming.setText("Grooming :  "+infor.getGrooming());
        holder.tvItemInforHealthIssues.setText("Health Issues :  "+infor.getHealth_issues());
        holder.tvItemInforIntelligence.setText("Intelligence :  "+infor.getIntelligence());
        holder.tvItemInforSheddingLevel.setText("Shedding Level :  "+infor.getShedding_level());
        holder.tvItemInforSocialNeeds.setText("Social Needs :  "+infor.getSocial_needs());
        holder.tvItemInforStrangerFriendly.setText("Stranger Friendly :  "+infor.getStranger_friendly());
        holder.tvItemInforVocalisation.setText("Vocalisation :  "+infor.getVocalisation());
        holder.tvItemInforBidability.setText("Bidability :  "+infor.getBidability());
        holder.tvItemInforExperimental.setText("Experimental :  "+infor.getExperimental());
        holder.tvItemInforHairless.setText("Hairless :  "+infor.getHairless());
        holder.tvItemInforNatural.setText("Natural :  "+infor.getNatural());
        holder.tvItemInforRare.setText("Rare :  "+infor.getRare());
        holder.tvItemInforRex.setText("Rex :  "+infor.getRex());
        holder.tvItemInforSuppressedTail.setText("Suppressed Tail :  "+infor.getSuppressed_tail());
        holder.tvItemInforShortLegs.setText("Short Legs :  "+infor.getShort_legs());
        holder.tvItemInforHypoallergenic.setText("Hypoallergenic :  "+infor.getHypoallergenic());
        holder.tvItemInforWikipediaUrl.setText("Wikipedia :  "+infor.getWikipedia_url());


    }

    @Override
    public int getItemCount() {
        if (infor!=null){
            return 1;
        }
        return 0;
    }

    public class InforViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgItemInfor;
        private TextView tvItemInforId;
        private TextView tvItemInforWeight;
        private TextView tvItemInforBreedsId;
        private TextView tvItemInforName;
        private TextView tvItemInforCfaUrl;
        private TextView tvItemInforVetstreetUrl;
        private TextView tvItemInforVcahospitalsUrl;
        private TextView tvItemInforTemperament;
        private TextView tvItemInforOrigin;
        private TextView tvItemInforCountryCodes;
        private TextView tvItemInforCountryCode;
        private TextView tvItemInforDescription;
        private TextView tvItemInforLifeSpan;
        private TextView tvItemInforIndoor;
        private TextView tvItemInforLap;
        private TextView tvItemInforAdaptability;
        private TextView tvItemInforAffectionLevel;
        private TextView tvItemInforChildFriendly;
        private TextView tvItemInforCatFriendly;
        private TextView tvItemInforDogFriendly;
        private TextView tvItemInforEnergyLevel;
        private TextView tvItemInforGrooming;
        private TextView tvItemInforHealthIssues;
        private TextView tvItemInforIntelligence;
        private TextView tvItemInforSheddingLevel;
        private TextView tvItemInforSocialNeeds;
        private TextView tvItemInforStrangerFriendly;
        private TextView tvItemInforVocalisation;
        private TextView tvItemInforBidability;
        private TextView tvItemInforExperimental;
        private TextView tvItemInforHairless;
        private TextView tvItemInforNatural;
        private TextView tvItemInforRare;
        private TextView tvItemInforRex;
        private TextView tvItemInforSuppressedTail;
        private TextView tvItemInforShortLegs;
        private TextView tvItemInforHypoallergenic;
        private TextView tvItemInforWikipediaUrl;



        public InforViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItemInfor = (ImageView) itemView.findViewById(R.id.img_item_infor);
            tvItemInforId = (TextView) itemView.findViewById(R.id.tv_item_infor_id);
            tvItemInforWeight = (TextView) itemView.findViewById(R.id.tv_item_infor_weight);
            tvItemInforBreedsId = (TextView) itemView.findViewById(R.id.tv_item_infor_breedsId);
            tvItemInforName = (TextView) itemView.findViewById(R.id.tv_item_infor_name);
            tvItemInforCfaUrl = (TextView) itemView.findViewById(R.id.tv_item_infor_cfa_url);
            tvItemInforVetstreetUrl = (TextView) itemView.findViewById(R.id.tv_item_infor_vetstreet_url);
            tvItemInforVcahospitalsUrl = (TextView) itemView.findViewById(R.id.tv_item_infor_vcahospitals_url);
            tvItemInforTemperament = (TextView) itemView.findViewById(R.id.tv_item_infor_temperament);
            tvItemInforOrigin = (TextView) itemView.findViewById(R.id.tv_item_infor_origin);
            tvItemInforCountryCodes = (TextView) itemView.findViewById(R.id.tv_item_infor_country_codes);
            tvItemInforCountryCode = (TextView) itemView.findViewById(R.id.tv_item_infor_country_code);
            tvItemInforDescription = (TextView) itemView.findViewById(R.id.tv_item_infor_description);
            tvItemInforLifeSpan = (TextView) itemView.findViewById(R.id.tv_item_infor_life_span);
            tvItemInforIndoor = (TextView) itemView.findViewById(R.id.tv_item_infor_indoor);
            tvItemInforLap = (TextView) itemView.findViewById(R.id.tv_item_infor_lap);
            tvItemInforAdaptability = (TextView) itemView.findViewById(R.id.tv_item_infor_adaptability);
            tvItemInforAffectionLevel = (TextView) itemView.findViewById(R.id.tv_item_infor_affection_level);
            tvItemInforChildFriendly = (TextView) itemView.findViewById(R.id.tv_item_infor_child_friendly);
            tvItemInforCatFriendly = (TextView) itemView.findViewById(R.id.tv_item_infor_cat_friendly);
            tvItemInforDogFriendly = (TextView) itemView.findViewById(R.id.tv_item_infor_dog_friendly);
            tvItemInforEnergyLevel = (TextView) itemView.findViewById(R.id.tv_item_infor_energy_level);
            tvItemInforGrooming = (TextView) itemView.findViewById(R.id.tv_item_infor_grooming);
            tvItemInforHealthIssues = (TextView) itemView.findViewById(R.id.tv_item_infor_health_issues);
            tvItemInforIntelligence = (TextView) itemView.findViewById(R.id.tv_item_infor_intelligence);
            tvItemInforSheddingLevel = (TextView) itemView.findViewById(R.id.tv_item_infor_shedding_level);
            tvItemInforSocialNeeds = (TextView) itemView.findViewById(R.id.tv_item_infor_social_needs);
            tvItemInforStrangerFriendly = (TextView) itemView.findViewById(R.id.tv_item_infor_stranger_friendly);
            tvItemInforVocalisation = (TextView) itemView.findViewById(R.id.tv_item_infor_vocalisation);
            tvItemInforBidability = (TextView) itemView.findViewById(R.id.tv_item_infor_bidability);
            tvItemInforExperimental = (TextView) itemView.findViewById(R.id.tv_item_infor_experimental);
            tvItemInforHairless = (TextView) itemView.findViewById(R.id.tv_item_infor_hairless);
            tvItemInforNatural = (TextView) itemView.findViewById(R.id.tv_item_infor_natural);
            tvItemInforRare = (TextView) itemView.findViewById(R.id.tv_item_infor_rare);
            tvItemInforRex = (TextView) itemView.findViewById(R.id.tv_item_infor_rex);
            tvItemInforSuppressedTail = (TextView) itemView.findViewById(R.id.tv_item_infor_suppressed_tail);
            tvItemInforShortLegs = (TextView) itemView.findViewById(R.id.tv_item_infor_short_legs);
            tvItemInforHypoallergenic = (TextView) itemView.findViewById(R.id.tv_item_infor_hypoallergenic);
            tvItemInforWikipediaUrl = (TextView) itemView.findViewById(R.id.tv_item_infor_wikipedia_url);

        }
    }
}
