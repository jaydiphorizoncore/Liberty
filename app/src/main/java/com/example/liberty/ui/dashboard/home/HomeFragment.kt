package com.example.liberty.ui.dashboard.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.liberty.R
import com.example.liberty.data.network.ApiInterface
import com.example.liberty.data.repository.ApiRepository
import com.example.liberty.data.network.response.dashboardresponse.BannerData
import com.example.liberty.data.network.response.dashboardresponse.DashboardResponse
import com.example.liberty.databinding.FragmentHomeBinding
import com.example.liberty.ui.dashboard.activity.CategoryActivity
import com.example.liberty.ui.dashboard.activity.CoursesActivity
import com.example.liberty.ui.dashboard.activity.DailyQuizActivity
import com.example.liberty.ui.dashboard.activity.PackageActivity
import com.example.liberty.ui.dashboard.activity.TestimonialActivity
import com.example.liberty.ui.dashboard.activity.ToppersActivity
import com.example.liberty.ui.dashboard.home.viewmodel.ApiViewModel
import com.example.liberty.ui.dashboard.home.viewmodel.ViewModelFactory
import com.example.liberty.ui.dashboard.home.category.adapter.CategoryAdapter
import com.example.liberty.ui.dashboard.home.courses.adapter.CoursesAdapter
import com.example.liberty.ui.dashboard.home.quiz.adapter.DailyQuizAdapter
import com.example.liberty.ui.dashboard.home.packages.adapter.PackageAdapter
import com.example.liberty.ui.dashboard.home.testimonials.adapter.TestimonialAdapter
import com.example.liberty.ui.dashboard.home.toppers.adapter.ToppersAdapter
import com.example.liberty.ui.dashboard.home.packages.model.PackageData
import com.example.liberty.ui.dashboard.home.imageslider.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener


class HomeFragment : Fragment(), DashboardInterface {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var imageList: List<BannerData>

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var testimonialAdapter: TestimonialAdapter
    private lateinit var toppersAdapter: ToppersAdapter
    private lateinit var quizAdapter: DailyQuizAdapter
    private lateinit var coursesAdapter: CoursesAdapter

    private lateinit var viewModel: ApiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        clickListener()
        preparePackageRecyclerView()
        prepareCoursesRecyclerView()
        prepareCategoryRecyclerView()
        prepareTestimonialRecyclerView()
        prepareToppersRecyclerView()
        prepareDailyQuizRecyclerView()

        val api = ApiInterface()
        val repository = ApiRepository(api)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[ApiViewModel::class.java]
        viewModel.dashboardInterface = this
        viewModel.getDashboard()

        return binding.root
    }

    private fun clickListener() {
        binding.tvPackage.setOnClickListener {
            val i = Intent(context, PackageActivity::class.java)
            startActivity(i)
        }
        binding.tvCourses.setOnClickListener {
            val i = Intent(context, CoursesActivity::class.java)
            startActivity(i)
        }
        binding.tvCategory.setOnClickListener {
            val i = Intent(context, CategoryActivity::class.java)
            startActivity(i)
        }
        binding.tvTestimonial.setOnClickListener {
            val i = Intent(context, TestimonialActivity::class.java)
            startActivity(i)
        }
        binding.tvToppers.setOnClickListener {
            val i = Intent(context, ToppersActivity::class.java)
            startActivity(i)
        }
        binding.tvDailyQuiz.setOnClickListener {
            val i = Intent(context, DailyQuizActivity::class.java)
            startActivity(i)
        }
    }

    private fun preparePackageRecyclerView() {
        val itemList = ArrayList<PackageData>()
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )

        val packageRecyclerAdapter = PackageAdapter(itemList)
        binding.recyclerPackages.adapter = packageRecyclerAdapter
    }

    private fun prepareCoursesRecyclerView() {
        coursesAdapter = CoursesAdapter(requireContext(), ArrayList())
        binding.recyclerCourses.adapter = coursesAdapter
    }

    private fun prepareCategoryRecyclerView() {

        categoryAdapter = CategoryAdapter(requireContext(), ArrayList())
        binding.recyclerCategory.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = categoryAdapter
        }

    }

    private fun prepareTestimonialRecyclerView() {
        testimonialAdapter = TestimonialAdapter(requireContext(), ArrayList())

        binding.recyclerTestimonial.apply {
            setHasFixedSize(true)
            adapter = testimonialAdapter
        }
    }

    private fun prepareToppersRecyclerView() {

        toppersAdapter = ToppersAdapter(requireContext(), ArrayList())
        binding.recyclerTopper.adapter = toppersAdapter

    }

    private fun prepareDailyQuizRecyclerView() {
        quizAdapter = DailyQuizAdapter(requireContext(), ArrayList())
        binding.recyclerDailyQuiz.adapter = quizAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tabLl.addTab(binding.tabLl.newTab())
        binding.tabLl.addTab(binding.tabLl.newTab())
        binding.tabLl.addTab(binding.tabLl.newTab())

        binding.viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(binding.tabLl))
        binding.tabLl.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }


    override fun onStarted() {
        Log.d("TAG", "onStartedDashBoard")
    }

    override fun onSuccess(dashboardResponse: DashboardResponse?) {
        binding.homeProgress.visibility = View.INVISIBLE
        binding.btnAllCourse.isSelected = true
        if (dashboardResponse != null) {
            Log.d("TAG", "onSuccess")

            imageList = ArrayList()

            imageList = dashboardResponse.data.bannerData

            viewPagerAdapter = ViewPagerAdapter(requireContext(), imageList)
            binding.viewPager.adapter = viewPagerAdapter

            categoryAdapter.setData(dashboardResponse.data.categories)
            testimonialAdapter.setData(dashboardResponse.data.testimonials.testimonialsData)
            toppersAdapter.setData(dashboardResponse.data.toppers.topersData)
            quizAdapter.setData(dashboardResponse.data.tests)

            coursesAdapter.setAllData(dashboardResponse.data.courses.allCourses.courses)
            binding.btnAllCourse.setOnClickListener {
                binding.btnAllCourse.setBackgroundResource(R.drawable.button_style)
                binding.btnAllCourse.isSelected = true
                binding.btnPopular.isSelected = false
                binding.btnAdvance.isSelected = false
                binding.btnNewest.isSelected = false
                coursesAdapter.setAllData(dashboardResponse.data.courses.allCourses.courses)
                binding.recyclerCourses.visibility = View.VISIBLE
                binding.tvDataNotFound.visibility = View.INVISIBLE
            }
            binding.btnPopular.setOnClickListener {
                binding.btnPopular.setBackgroundResource(R.drawable.button_style)
                binding.btnAllCourse.isSelected = false
                binding.btnPopular.isSelected = true
                binding.btnAdvance.isSelected = false
                binding.btnNewest.isSelected = false
                coursesAdapter.setAllData(dashboardResponse.data.courses.popularCourses.courses)
                binding.recyclerCourses.visibility = View.VISIBLE
                binding.tvDataNotFound.visibility = View.INVISIBLE
            }
            binding.btnAdvance.setOnClickListener {
                binding.btnPopular.setBackgroundResource(R.drawable.button_style)
                binding.btnAllCourse.isSelected = false
                binding.btnPopular.isSelected = false
                binding.btnAdvance.isSelected = true
                binding.btnNewest.isSelected = false
                coursesAdapter.setAllData(dashboardResponse.data.courses.advanceCourses.courses)
                binding.recyclerCourses.visibility = View.VISIBLE
                binding.tvDataNotFound.visibility = View.INVISIBLE
            }
            binding.btnNewest.setOnClickListener {
                binding.btnPopular.setBackgroundResource(R.drawable.button_style)
                binding.btnAllCourse.isSelected = false
                binding.btnPopular.isSelected = false
                binding.btnAdvance.isSelected = false
                binding.btnNewest.isSelected = true
                binding.recyclerCourses.visibility = View.INVISIBLE
                binding.tvDataNotFound.visibility = View.VISIBLE
            }

        }
    }


    override fun onFailure(message: String) {
        Log.d("TAG", "onFailure")
    }

}